/*    */ package com.antbox.common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RestCode
/*    */ {
/*  8 */   USERNAME_IS_NOT_EXIST("101", "用户名不存在"), 
/*  9 */   USER_STATUS_EXCEPTION("102", "用户名状态异常"), 
/* 10 */   PASSWORD_ERROR("103", "密码错误"), 
/* 11 */   ACCESS_TOKEN_IS_NOT_NULL("104", "access_token 不能为空"), 
/* 12 */   ACCESS_TOKEN_INVALID("105", "access_token 无效"), 
/* 13 */   USERNAME_IS_NOT_NULL("106", "用户名不能为空"), 
/* 14 */   NOT_LOGIN_PERMISSION("107", "您没有登录权限"), 
/* 15 */   DOMAIN_IS_NOT_NULL("108", "domain 不能为空"), 
/* 16 */   SYSTEM_IS_NOT_EXIST("109", "登录域名对应系统不存在"), 
/*    */   
/*    */ 
/* 19 */   PROMOTION_ACTIVITY_STARTTIME_NOT_BIGGER_THAN_ENDTIME("113", "活动开始时间需要大于结束时间"), 
/* 20 */   PROMOTION_ACTIVITY_TIME_CONFLICT("114", "活动时间冲突"), 
/* 21 */   PROMOTION_ACTIVITY_FIRST_SINGLE_NULL("115", "首单信息为空"), 
/* 22 */   PROMOTION_ACTIVITY_RANDOM_STAND_BY_NULL("116", "随机减信息为"), 
/* 23 */   PROMOTION_ACTIVITY_FULL_REDUCTION_NULL("117", "满减信息为空"), 
/* 24 */   PROMOTION_ACTIVITY_RANDOM_STAND_BY_MAX_DISCOUNT_NULL("118", "随机减的最大优惠为空"), 
/* 25 */   PROMOTION_ACTIVITY_RANDOM_STAND_BY_MIN_DISCOUNT_NULL("119", "随机减的最小优惠为空"), 
/* 26 */   PROMOTION_ACTIVITY_RANDOM_STAND_BY_MAX_SMALLER_THAN_MIN("120", "随机减的最大优惠不能小于最小优惠"), 
/* 27 */   PROMOTION_ACTIVITY_FULL_REDUCTION_FIRST_DISCOUNT_WRONG("121", "满减信息的一级优惠信息有误"), 
/* 28 */   PROMOTION_ACTIVITY_FULL_REDUCTION_SECOND_DISCOUNT_WRONG("121", "满减信息的二级优惠信息有误"), 
/* 29 */   PROMOTION_ACTIVITY_FULL_REDUCTION_THIRD_DISCOUNT_WRONG("121", "满减信息的三级优惠信息有误"), 
/* 30 */   PROMOTION_ACTIVITY_DUPLICATE("122", "该编号已有启用的活动"), 
/* 31 */   PROMOTION_ACTIVITY_INFO_WRONG("123", "活动必填信息不能为空"), 
/* 32 */   PROMOTION_ACTIVITY_DISCOUNT_NO_SMALLER_THAN_ZERO("124", "活动的折扣不能小于0");
/*    */   
/*    */   public String code;
/*    */   public String desc;
/*    */   
/*    */   private RestCode(String code, String desc) {
/* 38 */     this.code = code;
/* 39 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RestCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */