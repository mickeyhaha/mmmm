/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OrderDirection
/*    */ {
/* 10 */   DESC(Integer.valueOf(0), "降序"),  ASC(Integer.valueOf(1), "升序");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private OrderDirection(Integer code, String text) {
/* 16 */     this.text = text;
/* 17 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\OrderDirection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */