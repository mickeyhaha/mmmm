/*    */ package com.antbox.common;
/*    */ 
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum LogHelper
/*    */ {
/* 10 */   SINGLE;
/*    */   
/*    */   private LogHelper() {}
/* 13 */   public void errorLog(Logger log, Exception e) { log.error(ExceptionUtils.getStackTrace(e)); }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\LogHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */