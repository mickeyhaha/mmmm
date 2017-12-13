/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DistributionOrderItemRfidStatus
/*    */ {
/*  9 */   COMMON(Integer.valueOf(0), "正常"),  SOLD(Integer.valueOf(1), "已售");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private DistributionOrderItemRfidStatus(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DistributionOrderItemRfidStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */