/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CheckHelper
/*    */ {
/* 12 */   SINGLE;
/*    */   
/*    */   private CheckHelper() {}
/* 15 */   public void check(boolean cond, String desc) { if (!cond)
/* 16 */       throw new CheckException(desc);
/*    */   }
/*    */   
/*    */   public void checkNotNull(Object fieldValue, String desc) {
/* 20 */     if (null == fieldValue) {
/* 21 */       throw new CheckException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindNotEmptyList(Object fieldValue, String desc) {
/* 26 */     if (null == fieldValue) {
/* 27 */       throw new CheckException(desc);
/*    */     }
/* 29 */     if ((List.class.isAssignableFrom(fieldValue.getClass())) && (((List)fieldValue).size() == 0)) {
/* 30 */       throw new CheckException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void checkNotBlank(String field, String desc) {
/* 35 */     if (StringUtils.isBlank(field)) {
/* 36 */       throw new CheckException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindNotNul(Object fieldValue, String desc) {
/* 41 */     if (null == fieldValue) {
/* 42 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindIsNotExist(Object fieldValue, String desc) {
/* 47 */     if (null == fieldValue) {
/* 48 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindShouldBeNul(Object fieldValue, String desc) {
/* 53 */     if (fieldValue != null) {
/* 54 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindNotBlank(String field, String desc) {
/* 59 */     if (StringUtils.isBlank(field)) {
/* 60 */       throw new RemindException(desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindNotNul(Object fieldValue, String code, String desc) {
/* 65 */     if (null == fieldValue) {
/* 66 */       throw new RemindException(code, desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public void remindNotNul(Object fieldValue, RestCode restCode) {
/* 71 */     if (null == fieldValue) {
/* 72 */       throw new RemindException(restCode.code, restCode.desc);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CheckHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */