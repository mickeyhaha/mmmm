/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderPayExceptionType
/*    */ {
/*  8 */   INIT(Integer.valueOf(0), "初始化"), 
/*  9 */   COMMON(Integer.valueOf(1), "正常"), 
/* 10 */   ALIPAY_CREATE_EXCEPTION_AGREEMENT_NOT_EXIST(Integer.valueOf(2), "调用支付宝创建订单异常，用户签约号不存在"), 
/* 11 */   ALIPAY_CREATE_EXCEPTION_ILLEGAL_ARGUMENT(Integer.valueOf(3), "调用支付宝创建订单异常，参数错误"), 
/* 12 */   ALIPAY_CREATE_EXCEPTION_INVALID_PARAMETER(Integer.valueOf(4), "调用支付宝创建订单异常，参数无效"), 
/* 13 */   ALIPAY_CREATE_EXCEPTION_SYSTEM_ERROR(Integer.valueOf(5), "调用支付宝创建订单异常，系统错误"), 
/* 14 */   ALIPAY_CREATE_EXCEPTION_OTHER_ERROR(Integer.valueOf(6), "调用支付宝创建订单异常，其他错误"), 
/* 15 */   ALIPAY_CREATE_EXCEPTION_HTTP(Integer.valueOf(7), "调用支付宝创建订单异常，http 请求出错"), 
/* 16 */   ALIPAY_CREATE_EXCEPTION_BUYER_BANKCARD_BALANCE_NOT_ENOUGH(Integer.valueOf(8), "调用支付宝创建订单异常，用户银行卡余额不足"), 
/* 17 */   ALIPAY_CREATE_EXCEPTION_BUYER_BALANCE_NOT_ENOUGH(Integer.valueOf(9), "调用支付宝创建订单异常，家余额不足"), 
/* 18 */   WECHAT_CREATE_EXCEPTION_SYSTEM_ERROR(Integer.valueOf(10), "调用微信代扣创建订单异常，系统错误"), 
/* 19 */   WECHAT_CREATE_EXCEPTION_AGREEMENT_NOT_EXIST(Integer.valueOf(11), "调用微信代扣创建订单异常，用户签约号错误"), 
/* 20 */   WECHAT_CREATE_EXCEPTION_HTTP(Integer.valueOf(12), "调用微信代扣创建订单异常，http 请求出错");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private OrderPayExceptionType(Integer code, String text) {
/* 26 */     this.text = text;
/* 27 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 31 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 35 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderPayExceptionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */