/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ public enum BoxDoorCloseTimeType
/*    */ {
/*  5 */   ALL(Integer.valueOf(0), "全部"),  CLOSE(Integer.valueOf(1), "已关门"),  NOT_CLOSE(Integer.valueOf(2), "未关门");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private BoxDoorCloseTimeType(Integer code, String text) {
/* 11 */     this.code = code;
/* 12 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxDoorCloseTimeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */