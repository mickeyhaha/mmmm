/*    */ package com.antbox.common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckException
/*    */   extends RuntimeException
/*    */ {
/* 10 */   public String desc = RestResult.CD2[1];
/* 11 */   public String code = RestResult.CD2[0];
/*    */   public Object data;
/*    */   
/*    */   public CheckException(String desc) {
/* 15 */     super(desc);
/* 16 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public CheckException(String desc, Object data) {
/* 20 */     super(desc);
/* 21 */     this.desc = desc;
/* 22 */     this.data = data;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CheckException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */