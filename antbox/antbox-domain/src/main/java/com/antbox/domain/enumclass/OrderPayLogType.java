/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderPayLogType
/*    */ {
/*  8 */   WAIT(Integer.valueOf(0), "待支付"),  SUCCESS(Integer.valueOf(1), "支付成功"),  FAIL(Integer.valueOf(2), "支付失败"),  CALL_BACK_ORDER_NOT_EXIST(Integer.valueOf(3), "回调失败，订单不存在"),  CALL_BACK_SUCCEED_REPEAT(Integer.valueOf(4), "回调失败，订单已回调成功，支付宝重复回调了。"),  CALL_BACK_STATUS_EXCEPTION(Integer.valueOf(5), "回调失败，订单状态异常"),  CALL_BACK_ILLEGAL(Integer.valueOf(6), "恶意回调"),  CALL_BACK_STATUS_FAIL(Integer.valueOf(7), "回调失败，支付宝状态异常");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private OrderPayLogType(Integer code, String text) {
/* 14 */     this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderPayLogType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */