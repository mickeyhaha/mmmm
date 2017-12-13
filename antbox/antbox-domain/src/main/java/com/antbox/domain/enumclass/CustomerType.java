/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CustomerType
/*    */ {
/*  8 */   COMMON(Integer.valueOf(0), "普通顾客"),  WAREHOUSE_SUPERVISOR(Integer.valueOf(1), "补货员");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private CustomerType(Integer code, String text) {
/* 14 */     this.code = code;
/* 15 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\CustomerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */