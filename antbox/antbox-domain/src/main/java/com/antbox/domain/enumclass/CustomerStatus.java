/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CustomerStatus
/*    */ {
/*  8 */   COMMON(Integer.valueOf(0), "正常"),  BLACK_LIST(Integer.valueOf(1), "黑名单");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private CustomerStatus(Integer code, String text) {
/* 14 */     this.code = code;
/* 15 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\CustomerStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */