/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PromotionActivityType
/*    */ {
/* 10 */   FIRST_SINGLE(Integer.valueOf(0), "首单优惠"),  RANDOM_STAND_BY(Integer.valueOf(1), "随机减"),  FULL_REDUCTION(Integer.valueOf(2), "满减");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private PromotionActivityType(Integer code, String text) {
/* 16 */     this.text = text;
/* 17 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\PromotionActivityType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */