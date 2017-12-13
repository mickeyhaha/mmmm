/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxOpenDoorSource
/*    */ {
/*  7 */   ALIPAY("支付宝"),  WECHAT("微信"),  PARTNER("第三方"),  ILLEGAL("非法来源");
/*    */   
/*    */   private String text;
/*    */   
/*    */   private BoxOpenDoorSource(String text) {
/* 12 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxOpenDoorSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */