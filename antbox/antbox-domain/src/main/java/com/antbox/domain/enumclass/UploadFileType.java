/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum UploadFileType
/*    */ {
/*  9 */   CUSTOMER_PAGE_BACKGROUND("/customer/page/background", "加盟商客户配置图片"), 
/* 10 */   MALL_ICON("/mall/icon", "平台商图标"), 
/* 11 */   MERCHANT_ICON("/merchant/icon", "加盟商图标");
/*    */   
/*    */ 
/*    */   private String value;
/*    */   
/*    */   private String desc;
/*    */   
/*    */   private UploadFileType(String value, String desc)
/*    */   {
/* 20 */     this.value = value;
/* 21 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 25 */     return this.value;
/*    */   }
/*    */   
/*    */   public String getDesc()
/*    */   {
/* 30 */     return this.desc;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\UploadFileType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */