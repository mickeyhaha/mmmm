/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DeliveryOrderStatus
/*    */ {
/*  9 */   DRAFT(Integer.valueOf(0), "草稿"),  ENABLE(Integer.valueOf(1), "已发布"),  DISABLE(Integer.valueOf(2), "已取消");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private DeliveryOrderStatus(Integer code, String text) {
/* 15 */     this.text = text;
/* 16 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 20 */     String text = "";
/* 21 */     for (DeliveryOrderStatus status : values()) {
/* 22 */       if (status.code.toString().equals(value)) {
/* 23 */         text = status.text;
/*    */       }
/*    */     }
/* 26 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DeliveryOrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */