/*    */ package com.antbox.common;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.transaction.NoTransactionException;
/*    */ import org.springframework.transaction.TransactionStatus;
/*    */ import org.springframework.transaction.interceptor.TransactionAspectSupport;
/*    */ 
/*    */ 
/*    */ public abstract interface WebDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public String go(HttpServletRequest request, Logger log)
/*    */   {
/* 15 */     return invoke(request, log);
/*    */   }
/*    */   
/*    */   public String invoke(HttpServletRequest request, Logger log) {
/* 19 */     Long startTime = Long.valueOf(System.currentTimeMillis());
/* 20 */     log.info("############# current run method {} #####################################", Thread.currentThread().getStackTrace()[3].getMethodName());
/* 21 */     WebResult wr = new WebResult();
/*    */     try {
/* 23 */       showParams(request, log);
/* 24 */       service(wr);
/*    */     } catch (Exception e) {
/*    */       try {
/* 27 */         TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
/*    */       }
/*    */       catch (NoTransactionException localNoTransactionException) {}
/* 30 */       errorLog(log, e);
/*    */     } finally {
/* 32 */       log.info("############# current run method {} , processing time {} ms #############", Thread.currentThread().getStackTrace()[3].getMethodName(), Long.valueOf(System.currentTimeMillis() - startTime.longValue()));
/*    */     }
/* 34 */     return wr.view;
/*    */   }
/*    */   
/*    */   public abstract void service(WebResult paramWebResult)
/*    */     throws Exception;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\WebDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */