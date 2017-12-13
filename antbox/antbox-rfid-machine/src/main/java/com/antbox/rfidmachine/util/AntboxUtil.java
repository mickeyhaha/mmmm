/*     */ package com.antbox.rfidmachine.util;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AntboxUtil
/*     */ {
/*     */   static final int CRC_POLYNOMIAL = 33800;
/*     */   static final int CRC_START_VALUE = 65535;
/*     */   
/*     */   public static int calcCrc(ByteBuf buf, int offset)
/*     */   {
/*  33 */     int crc = 65535;
/*  34 */     int LEN = buf.readableBytes();
/*  35 */     for (int i = offset; i < LEN; i++) {
/*  36 */       crc ^= buf.getUnsignedByte(i);
/*  37 */       for (int j = 0; j < 8; j++) {
/*  38 */         if (notZero(crc & 0x1)) {
/*  39 */           crc = crc >> 1 ^ 0x8408;
/*     */         } else {
/*  41 */           crc >>= 1;
/*     */         }
/*     */       }
/*     */     }
/*  45 */     int lsb = crc & 0xFF;
/*  46 */     int msb = crc >> 8 & 0xFF;
/*  47 */     return lsb << 8 | msb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void writeDate(Date date, ByteBuf dataBuf)
/*     */   {
/*  55 */     Calendar c = Calendar.getInstance();
/*  56 */     c.setTime(date);
/*  57 */     int y = c.get(1);
/*  58 */     int m = c.get(2) + 1;
/*  59 */     int d = c.get(5);
/*  60 */     int h = c.get(11);
/*  61 */     int i = c.get(12);
/*  62 */     int s = c.get(13);
/*  63 */     dataBuf.writeByte(toByteForDate(y % 100));
/*  64 */     dataBuf.writeByte(toByteForDate(m));
/*  65 */     dataBuf.writeByte(toByteForDate(d));
/*  66 */     dataBuf.writeByte(toByteForDate(h));
/*  67 */     dataBuf.writeByte(toByteForDate(i));
/*  68 */     dataBuf.writeByte(toByteForDate(s));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Date readDate(ByteBuf dataBuf)
/*     */   {
/*  78 */     byte[] time = new byte[6];
/*  79 */     dataBuf.readBytes(time, 0, time.length);
/*  80 */     Calendar c = Calendar.getInstance();
/*  81 */     c.set(1, 100 * (c.get(1) / 100) + time[0]);
/*  82 */     c.set(2, time[1] - 1);
/*  83 */     c.set(5, time[2]);
/*  84 */     c.set(11, time[3]);
/*  85 */     c.set(12, time[4]);
/*  86 */     c.set(13, time[5]);
/*  87 */     return c.getTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte byteAt(long x, int pos)
/*     */   {
/* 100 */     return (byte)(int)(x >>> 8 * pos & 0xFF);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long shiftLeft(byte b, int byteOffset)
/*     */   {
/* 113 */     return (0xFF & b) << 8 * byteOffset;
/*     */   }
/*     */   
/*     */   private static short toByteForDate(int i) {
/* 117 */     return (short)i;
/*     */   }
/*     */   
/*     */   public static boolean notZero(int k) {
/* 121 */     return k != 0L;
/*     */   }
/*     */   
/*     */   public static String hexDump(byte[] buffer) {
/* 125 */     StringBuilder sb = new StringBuilder();
/* 126 */     for (byte b : buffer) {
/* 127 */       sb.append(' ');
/* 128 */       String x = Integer.toHexString(0xFF & b);
/* 129 */       if (x.length() < 2) {
/* 130 */         sb.append('0');
/*     */       }
/* 132 */       sb.append(x);
/*     */     }
/* 134 */     return sb.substring(1);
/*     */   }
/*     */   
/*     */   public static String leftPad(String str, int len, char pad) {
/* 138 */     StringBuilder sb = new StringBuilder();
/* 139 */     for (int i = 0; i < len - str.length(); i++) {
/* 140 */       sb.append(pad);
/*     */     }
/* 142 */     sb.append(str);
/* 143 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\util\AntboxUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */