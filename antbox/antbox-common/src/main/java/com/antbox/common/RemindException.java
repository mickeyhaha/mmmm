/*    */ package com.antbox.common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RemindException
/*    */   extends RuntimeException
/*    */ {
/* 10 */   public String desc = RestResult.CD3[1];
/* 11 */   public String code = RestResult.CD3[0];
/*    */   public Object data;
/*    */   
/*    */   public RemindException(String desc) {
/* 15 */     super(desc);
/* 16 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public RemindException(String code, String desc) {
/* 20 */     super(desc);
/* 21 */     this.code = code;
/* 22 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public RemindException(RestCode restCode) {
/* 26 */     super(restCode.desc);
/* 27 */     this.code = restCode.code;
/* 28 */     this.desc = restCode.desc;
/*    */   }
/*    */   
/*    */   public RemindException(String desc, Object data) {
/* 32 */     super(desc);
/* 33 */     this.desc = desc;
/* 34 */     this.data = data;
/*    */   }
/*    */   
/*    */   public RemindException(String code, String desc, Object data) {
/* 38 */     super(desc);
/* 39 */     this.code = code;
/* 40 */     this.desc = desc;
/* 41 */     this.data = data;
/*    */   }
/*    */   
/*    */   public RemindException(RestCode restCode, Object data) {
/* 45 */     super(restCode.desc);
/* 46 */     this.code = restCode.code;
/* 47 */     this.desc = restCode.desc;
/* 48 */     this.data = data;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RemindException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */