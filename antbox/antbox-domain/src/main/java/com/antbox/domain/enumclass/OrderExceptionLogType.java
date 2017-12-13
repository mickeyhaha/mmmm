/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderExceptionLogType
/*    */ {
/*  8 */   COMMON(Integer.valueOf(0), "正常"), 
/*  9 */   ALIPAY_CREATE_EXCEPTION(Integer.valueOf(1), "调用支付宝创建订单异常"), 
/* 10 */   ALIPAY_CALLBACK_EXCEPTION(Integer.valueOf(2), "支付宝回调异常"), 
/* 11 */   RFID_IS_NULL(Integer.valueOf(3), "rfid列表为空"), 
/* 12 */   RFID_SOLD(Integer.valueOf(4), "rfid产品已售异常"), 
/* 13 */   RFID_PRODUCT_IS_NOT_EXIST(Integer.valueOf(5), "rfid对应产品不存在"), 
/* 14 */   RFID_IS_NOT_BINDING(Integer.valueOf(6), "rfid没有绑定商品"), 
/* 15 */   RFID_LIST_INVALID(Integer.valueOf(7), "没有有效rfid列表"), 
/* 16 */   CODE_EXCEPTION(Integer.valueOf(8), "代码异常"), 
/* 17 */   MERCHANT_ALIPAY_CONFIG_OPENID_IS_NULL(Integer.valueOf(9), "商家openid为空"), 
/* 18 */   MERCHANT_ALIPAY_CONFIG_IS_NOT_EXIST(Integer.valueOf(10), "商家支付宝配置不存在"), 
/* 19 */   MERCHANT_IS_NOT_EXIST(Integer.valueOf(11), "商家不存在"), 
/* 20 */   CUSTOMER_IS_NOT_EXIST(Integer.valueOf(12), "购买客户不存在"), 
/* 21 */   BOX_IS_NOT_EXIST(Integer.valueOf(13), "售货机不存在"), 
/* 22 */   BOX_OPEN_DOOR_SOURCE_IS_NULL(Integer.valueOf(14), "开门来源"), 
/* 23 */   WECHAT_CREATE_EXCEPTION(Integer.valueOf(15), "调用微信创建订单异常"), 
/* 24 */   WECHAT_CONTRACT_NOT_EXIST(Integer.valueOf(15), "签约号无效");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private OrderExceptionLogType(Integer code, String text) {
/* 30 */     this.text = text;
/* 31 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderExceptionLogType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */