/*     */ package com.antbox.common;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public final class DefaultKeyGenerator
/*     */   implements KeyGenerator
/*     */ {
/*  18 */   private Logger log = LoggerFactory.getLogger(DefaultKeyGenerator.class);
/*     */   
/*     */   public static final long EPOCH;
/*     */   
/*     */   public static final String WORKER_ID_PROPERTY_KEY = "sharding-jdbc.default.key.generator.worker.id";
/*     */   
/*     */   public static final String WORKER_ID_ENV_KEY = "SHARDING_JDBC_DEFAULT_KEY_GENERATOR_WORKER_ID";
/*     */   
/*     */   private static final long SEQUENCE_BITS = 12L;
/*     */   
/*     */   private static final long WORKER_ID_BITS = 10L;
/*     */   
/*     */   private static final long SEQUENCE_MASK = 4095L;
/*     */   
/*     */   private static final long WORKER_ID_LEFT_SHIFT_BITS = 12L;
/*     */   
/*     */   private static final long TIMESTAMP_LEFT_SHIFT_BITS = 22L;
/*     */   
/*     */   private static final long WORKER_ID_MAX_VALUE = 1024L;
/*     */   
/*     */   private static long workerId;
/*  39 */   private Random random = new Random();
/*     */   private long sequence;
/*     */   
/*  42 */   static { Calendar calendar = Calendar.getInstance();
/*  43 */     calendar.set(2016, 10, 1);
/*  44 */     calendar.set(11, 0);
/*  45 */     calendar.set(12, 0);
/*  46 */     calendar.set(13, 0);
/*  47 */     calendar.set(14, 0);
/*  48 */     EPOCH = calendar.getTimeInMillis();
/*  49 */     initWorkerId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void initWorkerId()
/*     */   {
/*  57 */     String workerId = System.getProperty("sharding-jdbc.default.key.generator.worker.id");
/*  58 */     if (StringUtils.isNotBlank(workerId)) {
/*  59 */       setWorkerId(Long.valueOf(workerId).longValue());
/*  60 */       return;
/*     */     }
/*  62 */     workerId = System.getenv("SHARDING_JDBC_DEFAULT_KEY_GENERATOR_WORKER_ID");
/*  63 */     if (StringUtils.isBlank(workerId)) {
/*  64 */       return;
/*     */     }
/*  66 */     setWorkerId(Long.valueOf(workerId).longValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setWorkerId(long workerId)
/*     */   {
/*  75 */     if ((workerId >= 0L) && (workerId < 1024L)) {
/*  76 */       workerId = workerId;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private long lastTime;
/*     */   
/*     */ 
/*     */   public synchronized Number generateKey()
/*     */   {
/*  87 */     long currentMillis = System.currentTimeMillis();
/*  88 */     if (this.lastTime <= currentMillis) {
/*  89 */       if (this.lastTime == currentMillis) {
/*  90 */         if (0L == (this.sequence = ++this.sequence & 0xFFF)) {
/*  91 */           currentMillis = waitUntilNextTime(currentMillis);
/*     */         }
/*     */       } else {
/*  94 */         this.sequence = this.random.nextInt(2);
/*     */       }
/*  96 */       this.lastTime = currentMillis;
/*  97 */       if (this.log.isDebugEnabled()) {
/*  98 */         this.log.debug("{}-{}-{}", new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(this.lastTime)), Long.valueOf(workerId), Long.valueOf(this.sequence) });
/*     */       }
/* 100 */       return Long.valueOf(currentMillis - EPOCH << 22 | workerId << 12 | this.sequence);
/*     */     }
/* 102 */     return Integer.valueOf(0);
/*     */   }
/*     */   
/*     */   private long waitUntilNextTime(long lastTime) {
/* 106 */     long time = System.currentTimeMillis();
/* 107 */     while (time <= lastTime) {
/* 108 */       time = System.currentTimeMillis();
/*     */     }
/* 110 */     return time;
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\DefaultKeyGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */