/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderBoxInventoryHandleType
/*    */ {
/*  9 */   WAIT(Integer.valueOf(0), "待处理"),  PROCESSED(Integer.valueOf(1), "已处理"),  IGNORE(Integer.valueOf(2), "忽略");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private OrderBoxInventoryHandleType(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 19 */     String text = "";
/* 20 */     for (OrderBoxInventoryHandleType status : values()) {
/* 21 */       if (status.code.toString().equals(value)) {
/* 22 */         text = status.text;
/*    */       }
/*    */     }
/* 25 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderBoxInventoryHandleType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */