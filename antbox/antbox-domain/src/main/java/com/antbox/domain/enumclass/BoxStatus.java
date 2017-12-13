/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxStatus
/*    */ {
/*  8 */   ONLINE("在线"),  OFFLINE("离线"),  BREAKDOWN("故障");
/*    */   
/*    */   public String text;
/*    */   
/*    */   private BoxStatus(String text) {
/* 13 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */