/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum StoreStandardStatus
/*    */ {
/*  9 */   DISABLE(Integer.valueOf(0), "关闭"),  ENABLE(Integer.valueOf(1), "开启");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private StoreStandardStatus(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 19 */     String text = "";
/* 20 */     for (StoreStandardStatus status : values()) {
/* 21 */       if (status.code.toString().equals(value)) {
/* 22 */         text = status.text;
/*    */       }
/*    */     }
/* 25 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\StoreStandardStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */