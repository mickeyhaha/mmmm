/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ public enum BoxInventoryType {
/*  4 */   CLOSED((byte)0, "关门盘点"),  CMD((byte)1, "指令盘点");
/*    */   
/*    */   byte code;
/*    */   String desc;
/*    */   
/*    */   private BoxInventoryType(byte code, String desc) {
/* 10 */     this.code = code;
/* 11 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public static BoxInventoryType getByCode(byte code) {
/* 15 */     for (BoxInventoryType type : BoxInventoryType.values()) {
/* 16 */       if (Byte.parseByte(Integer.toHexString(type.code)) == code) { return type;
/*    */       }
/*    */     }
/* 19 */     return null;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 23 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 27 */     return this.desc;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\BoxInventoryType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */