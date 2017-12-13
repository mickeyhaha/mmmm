/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderSource
/*    */ {
/*  8 */   ALIPAY_FREE_PAYMENT(Integer.valueOf(0), "支付宝首次开通免密支付"),  ALIPAY_SHOPPING(Integer.valueOf(1), "支付宝"),  WECHAT_SHOPPING(Integer.valueOf(2), "微信");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 13 */   private OrderSource(Integer code, String text) { this.text = text;
/* 14 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */