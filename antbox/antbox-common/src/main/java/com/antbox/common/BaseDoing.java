/*     */ package com.antbox.common;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonProcessingException;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.io.IOException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ public abstract interface BaseDoing<T>
/*     */ {
/*     */   public void showRequestBody(Object body, ObjectMapper objectMapper, Logger log) throws JsonProcessingException
/*     */   {
/*  18 */     if ((body != null) && (objectMapper != null)) {
/*  19 */       log.info("request body : {}", objectMapper.writeValueAsString(body));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void showParams(HttpServletRequest request, Logger log)
/*     */     throws IOException
/*     */   {
/*  30 */     if ((request != null) && ("GET".equals(request.getMethod()))) {
/*  31 */       Enumeration<String> paramsEnumeration = request.getParameterNames();
/*  32 */       StringBuilder parameterStringBuffer = new StringBuilder("params => { ");
/*  33 */       while (paramsEnumeration.hasMoreElements()) {
/*  34 */         String name = (String)paramsEnumeration.nextElement();
/*  35 */         parameterStringBuffer.append(name).append(" : ").append(request.getParameter(name)).append(" ,");
/*     */       }
/*  37 */       parameterStringBuffer.deleteCharAt(parameterStringBuffer.length() - 1);
/*  38 */       parameterStringBuffer.append(" }");
/*  39 */       log.info(parameterStringBuffer.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public void showErrorLog(Exception e, Logger log) {
/*  44 */     showErrorLog(null, e, log);
/*     */   }
/*     */   
/*     */   public void showErrorLog(RestResult restResult, Exception e, Logger log) {
/*  48 */     if (restResult != null) {
/*  49 */       restResult.setCode(RestResult.CD0[0]);
/*  50 */       restResult.setDesc(RestResult.CD0[1]);
/*     */     }
/*  52 */     log.error(e.getMessage());
/*  53 */     StackTraceElement[] stackTraceElements = e.getStackTrace();
/*  54 */     for (int i = 0; i < stackTraceElements.length; i++) {
/*  55 */       StackTraceElement stackTraceElement = stackTraceElements[i];
/*  56 */       log.error(stackTraceElement.toString());
/*     */     }
/*  58 */     e.printStackTrace();
/*     */   }
/*     */   
/*     */   public void showReturnData(RestResult jr, ObjectMapper objectMapper, Logger log) {
/*  62 */     if (objectMapper != null) {
/*     */       try {
/*  64 */         if (jr.code.equals(RestResult.CD0[0])) {
/*  65 */           log.error("response : {}", objectMapper.writeValueAsString(jr));
/*  66 */         } else if (jr.code.equals(RestResult.CD1[0])) {
/*  67 */           log.info("response : {}", objectMapper.writeValueAsString(jr));
/*     */         } else {
/*  69 */           log.warn("response : {}", objectMapper.writeValueAsString(jr));
/*     */         }
/*     */       } catch (JsonProcessingException e) {
/*  72 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void showVisitor(Object merchantDto, ObjectMapper objectMapper, Logger log) throws JsonProcessingException
/*     */   {
/*  79 */     if ((objectMapper != null) && (merchantDto != null)) {
/*  80 */       log.info("visitor : {} ", objectMapper.writeValueAsString(merchantDto));
/*     */     }
/*     */   }
/*     */   
/*     */   public void errorCheckLog(Logger log, CheckException e, RestResult<T> restResult) {
/*  85 */     restResult.setCode(e.code);
/*  86 */     restResult.setDesc(e.desc);
/*  87 */     restResult.setData(e.data);
/*  88 */     showWarnLog(log, restResult);
/*     */   }
/*     */   
/*     */   public void errorRemindLog(Logger log, RemindException e, RestResult<T> restResult) {
/*  92 */     restResult.setCode(e.code);
/*  93 */     restResult.setDesc(e.desc);
/*  94 */     restResult.setData(e.data);
/*  95 */     showWarnLog(log, restResult);
/*     */   }
/*     */   
/*     */   public void showWarnLog(Logger log, RestResult restResult) {
/*  99 */     log.warn("code : {} , desc : {}", restResult.code, restResult.desc);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void errorLog(Logger log, Exception e, RestResult<T> jr)
/*     */   {
/* 110 */     jr.setCode(RestResult.CD0[0]);
/* 111 */     jr.setDesc(RestResult.CD0[1]);
/* 112 */     errorLog(log, e);
/*     */   }
/*     */   
/*     */   public void errorLog(Logger log, Exception e)
/*     */   {
/* 117 */     log.error(ExceptionUtils.getStackTrace(e));
/*     */   }
/*     */   
/*     */ 
/*     */   public void showSql(Map<String, Object> params, String sqlName, String sql, Logger log)
/*     */   {
/* 123 */     Set<String> paramsKeys = params.keySet();
/* 124 */     Iterator<String> keys = paramsKeys.iterator();
/* 125 */     while (keys.hasNext()) {
/* 126 */       String key = (String)keys.next();
/* 127 */       sql = sql.replace(":" + key, params.get(key).toString());
/*     */     }
/*     */     
/* 130 */     log.info("{} : {}", sqlName, sql);
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */