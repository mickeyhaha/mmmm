/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DistributionOrderType
/*    */ {
/*  9 */   COMMON(Integer.valueOf(0), "正常配货"),  DYNAMIC(Integer.valueOf(1), "动态配货");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private DistributionOrderType(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DistributionOrderType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */