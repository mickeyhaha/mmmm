/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxScanType
/*    */ {
/*  8 */   WECHAT("微信"),  ALIPAY("支付宝"),  ALL("全部");
/*    */   
/*    */   public String text;
/*    */   
/*    */   private BoxScanType(String text) {
/* 13 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxScanType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */