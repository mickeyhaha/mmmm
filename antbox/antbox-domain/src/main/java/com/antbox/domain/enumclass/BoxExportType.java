/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BoxExportType
/*    */ {
/*  8 */   SINGLE(Integer.valueOf(0), "单个"),  LIST(Integer.valueOf(1), "列表");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private BoxExportType(Integer code, String text) {
/* 14 */     this.code = code;
/* 15 */     this.text = text;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxExportType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */