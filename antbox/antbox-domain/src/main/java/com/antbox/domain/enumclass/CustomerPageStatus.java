/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CustomerPageStatus
/*    */ {
/* 10 */   DEFAULT(Integer.valueOf(0), "默认"),  CUSTOMIZE(Integer.valueOf(1), "自定义");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private CustomerPageStatus(Integer code, String text) {
/* 16 */     this.text = text;
/* 17 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\CustomerPageStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */