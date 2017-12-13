/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ public enum BoxDoorOpenTimeType
/*    */ {
/*  5 */   ALL(Integer.valueOf(0), "全部"),  OPEN(Integer.valueOf(1), "已开门"),  NOT_OPEN(Integer.valueOf(2), "未开门");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private BoxDoorOpenTimeType(Integer code, String text) {
/* 11 */     this.code = code;
/* 12 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxDoorOpenTimeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */