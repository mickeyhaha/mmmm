/*    */ package com.antbox.common;
/*    */ 
/*    */ 
/*    */ public class WebResult
/*    */ {
/*    */   public String view;
/*    */   
/*    */ 
/*    */   public void redirectView(String url)
/*    */   {
/* 11 */     this.view = ("redirect:" + url);
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\WebResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */