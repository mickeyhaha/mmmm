/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxOpenDoorType
/*    */ {
/*  8 */   COMMON(Integer.valueOf(0), "购物"),  DISTRIBUTION(Integer.valueOf(1), "补货");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private BoxOpenDoorType(Integer code, String text) {
/* 14 */     this.code = code;
/* 15 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxOpenDoorType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */