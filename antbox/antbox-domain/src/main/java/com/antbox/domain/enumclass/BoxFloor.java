/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxFloor
/*    */ {
/*  9 */   ZERO(Integer.valueOf(0), "第零层"),  FIRST(Integer.valueOf(1), "第一层"),  SECOND(Integer.valueOf(2), "第二层"),  THIRD(Integer.valueOf(3), "第三层"),  FOURTH(Integer.valueOf(4), "第四层"),  FIFTH(Integer.valueOf(5), "第二层");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private BoxFloor(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */   
/*    */   public static String getText(String value) {
/* 19 */     String text = "";
/* 20 */     for (BoxFloor status : values()) {
/* 21 */       if (status.code.toString().equals(value)) {
/* 22 */         text = status.text;
/*    */       }
/*    */     }
/* 25 */     return text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxFloor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */