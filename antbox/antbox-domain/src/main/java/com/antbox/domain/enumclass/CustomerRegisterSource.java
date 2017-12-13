/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CustomerRegisterSource
/*    */ {
/*  8 */   ALIPAY(Integer.valueOf(0), "支付宝"),  WECHAT(Integer.valueOf(1), "微信"),  THIRD_PARTY_APP(Integer.valueOf(2), "第三方app");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 13 */   private CustomerRegisterSource(Integer code, String text) { this.text = text;
/* 14 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\CustomerRegisterSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */