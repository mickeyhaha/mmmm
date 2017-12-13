/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PromotionActivityConsumptionStatus
/*    */ {
/* 10 */   USED(Integer.valueOf(0), "已用"),  ROLLBACK(Integer.valueOf(1), "被退回");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private PromotionActivityConsumptionStatus(Integer code, String text) {
/* 16 */     this.text = text;
/* 17 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\PromotionActivityConsumptionStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */