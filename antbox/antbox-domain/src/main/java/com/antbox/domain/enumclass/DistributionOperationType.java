/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DistributionOperationType
/*    */ {
/*  9 */   OFF(Integer.valueOf(0), "下架"),  ON(Integer.valueOf(1), "上架");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/* 14 */   private DistributionOperationType(Integer code, String text) { this.text = text;
/* 15 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\DistributionOperationType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */