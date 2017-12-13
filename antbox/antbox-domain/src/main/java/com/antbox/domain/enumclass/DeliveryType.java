/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DeliveryType
/*    */ {
/*  9 */   STOCK_IN(Integer.valueOf(0), "上架"),  STOCK_OUT(Integer.valueOf(1), "下架");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private DeliveryType(Integer code, String text) {
/* 15 */     this.text = text;
/* 16 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 20 */     String text = "";
/* 21 */     for (DeliveryType status : values()) {
/* 22 */       if (status.code.toString().equals(value)) {
/* 23 */         text = status.text;
/*    */       }
/*    */     }
/* 26 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DeliveryType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */