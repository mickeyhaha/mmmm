/*    */ package com.antbox.common;
/*    */ 
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Sort.Direction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseController
/*    */ {
/*    */   protected PageRequest getJpaPageRequest(Integer page, Integer size, Sort.Direction direction, String fieldName)
/*    */   {
/* 17 */     if ((page == null) || (page.intValue() <= 0)) {
/* 18 */       page = Integer.valueOf(0);
/*    */     }
/*    */     
/* 21 */     if ((size == null) || (size.intValue() < 0))
/* 22 */       size = Integer.valueOf(10);
/*    */     PageRequest pageRequest;
/*    */     PageRequest pageRequest;
/* 25 */     if ((direction != null) && (fieldName != null)) {
/* 26 */       pageRequest = new PageRequest(page.intValue(), size.intValue(), direction, new String[] { fieldName });
/*    */     } else {
/* 28 */       pageRequest = new PageRequest(page.intValue(), size.intValue());
/*    */     }
/*    */     
/* 31 */     return pageRequest;
/*    */   }
/*    */   
/*    */   protected PageRequest getJpaPageRequest(Integer pageNo, Integer pageSize) {
/* 35 */     return getJpaPageRequest(pageNo, pageSize, Sort.Direction.ASC, "createdAt");
/*    */   }
/*    */   
/*    */ 
/*    */   protected Integer getOffset(Integer offset)
/*    */   {
/* 41 */     if ((offset == null) || (offset.intValue() <= 0)) {
/* 42 */       offset = Integer.valueOf(0);
/*    */     }
/* 44 */     return offset;
/*    */   }
/*    */   
/*    */   protected Integer getSize(Integer size) {
/* 48 */     if ((size == null) || (size.intValue() <= 0)) {
/* 49 */       size = Integer.valueOf(10);
/*    */     }
/* 51 */     return size;
/*    */   }
/*    */   
/*    */   protected void showErrorLog(Exception e, Logger log) {
/* 55 */     log.error(e.getMessage());
/* 56 */     StackTraceElement[] stackTraceElements = e.getStackTrace();
/* 57 */     for (StackTraceElement stackTraceElement : stackTraceElements) {
/* 58 */       log.error(stackTraceElement.toString());
/*    */     }
/*    */   }
/*    */   
/*    */   protected void checkNotNull(Object fieldValue, String desc) {
/* 63 */     if (null == fieldValue) {
/* 64 */       throw new CheckException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void remindNotNul(Object fieldValue, String desc) {
/* 69 */     if (null == fieldValue) {
/* 70 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void remindNotEquals(Object source, Object target, String desc) {
/* 75 */     if (!source.equals(target)) {
/* 76 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void remind(String desc) {
/* 81 */     throw new RemindException(desc);
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */