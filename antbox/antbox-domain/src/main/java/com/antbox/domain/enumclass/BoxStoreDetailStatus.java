/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxStoreDetailStatus
/*    */ {
/*  9 */   NORMAL("正常"),  SOLD("已出售"),  EXPIRED("已过期"),  EXPIRED_AND_SALED("过期且出售");
/*    */   
/*    */   public String text;
/*    */   
/* 13 */   private BoxStoreDetailStatus(String text) { this.text = text; }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxStoreDetailStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */