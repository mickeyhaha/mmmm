/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxOpenDoorCode
/*    */ {
/*  8 */   SUCCESS("1200", "成功"), 
/*  9 */   ERROR("1201", "普通错误"), 
/* 10 */   KEY_INVALID("1202", "openDoorKey 无效"), 
/* 11 */   NOT_DISTRIBUTION_PREMISSION("1203", "没有补货员权限"), 
/* 12 */   DEVICE_IS_BUSY("1204", "售货机正在繁忙"), 
/* 13 */   TRADING_WITH_OTHER("1205", "售货机正与其他用户交易中"), 
/* 14 */   DEVICE_NOT_REGISTER("1206", "售货机没有注册在server"), 
/* 15 */   ORDER_NOT_COMPLETED("1207", "您有订单没有支付"), 
/* 16 */   MERCHANT_IS_NOT_SUPPORT_SCAN_TYPE("1208", "商家不支持扫码类型"), 
/* 17 */   CUSTOMER_IN_BLACKLIST("1209", "您的账号状态异常，如有疑问请联系客服"), 
/*    */   
/*    */ 
/* 20 */   TIMESTAMP("1302", "timestamp时间戳为空"), 
/* 21 */   SIGN("1303", "sign签名不能为空"), 
/* 22 */   SIGN_IS_WRONG("1304", "sign签名有误"), 
/* 23 */   BOX_OPEN_DOOR_SOURCE("1305", "boxOpenDoorSource不能为空"), 
/* 24 */   BOX_ID("1306", "boxId不能为空"), 
/* 25 */   CUSTOMER_MOBILE("1307", "customerMobile用户手机号码不能为空"), 
/* 26 */   CUSTOMER_MOBILE_WRONG("1313", "customerMobile用户手机号码有误"), 
/* 27 */   BOX_IS_NOT_EXIST("1308", "售后机不存在"), 
/* 28 */   DISTRIBUTION("1309", "distribution是否补货员不能为空"), 
/* 29 */   PARTNER_CUSTOMER_ID("1310", "partnerCustomerId第三方用户id不能为空"), 
/* 30 */   PARTNER_CUSTOMER_ID_LENGTH("1312", "partnerCustomerId第三方用户最长为32位"), 
/* 31 */   BOX_OPEN_DOOR_SOURCE_VALUE_IS_WRONG("1311", "boxOpenDoorSource值错误");
/*    */   
/*    */   public String code;
/*    */   public String text;
/*    */   
/*    */   private BoxOpenDoorCode(String code, String text) {
/* 37 */     this.text = text;
/* 38 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxOpenDoorCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */