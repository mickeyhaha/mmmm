/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DistributionOrderStatus
/*    */ {
/*  9 */   WAIT(Integer.valueOf(0), "待配货"),  PROCESSING(Integer.valueOf(1), "配货中"),  SUCCESS(Integer.valueOf(2), "完成"),  CANCEL(Integer.valueOf(3), "取消配货");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private DistributionOrderStatus(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DistributionOrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */