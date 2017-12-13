/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderStatus
/*    */ {
/*  9 */   WAIT(Integer.valueOf(0), "待支付"),  SUCCESS(Integer.valueOf(1), "支付成功"),  FAIL(Integer.valueOf(2), "支付失败");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private OrderStatus(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 19 */     String text = "";
/* 20 */     for (OrderStatus status : values()) {
/* 21 */       if (status.code.toString().equals(value)) {
/* 22 */         text = status.text;
/*    */       }
/*    */     }
/* 25 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */