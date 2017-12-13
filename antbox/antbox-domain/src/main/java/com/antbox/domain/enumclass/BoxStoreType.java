/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxStoreType
/*    */ {
/*  9 */   STANDARD(Integer.valueOf(0), "标准库存"),  NONSTANDARD(Integer.valueOf(1), "非标准库存");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private BoxStoreType(Integer code, String text) {
/* 15 */     this.text = text;
/* 16 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 20 */     String text = "";
/* 21 */     for (BoxStoreType status : values()) {
/* 22 */       if (status.code.toString().equals(value)) {
/* 23 */         text = status.text;
/*    */       }
/*    */     }
/* 26 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxStoreType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */