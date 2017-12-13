/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PromotionActivityStatus
/*    */ {
/* 10 */   ON(Integer.valueOf(0), "开启"),  OFF(Integer.valueOf(1), "关闭");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private PromotionActivityStatus(Integer code, String text) {
/* 16 */     this.text = text;
/* 17 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\PromotionActivityStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */