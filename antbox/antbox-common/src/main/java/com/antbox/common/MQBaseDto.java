/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MQBaseDto
/*    */ {
/*  9 */   private String msgId = UUID.randomUUID().toString();
/*    */   
/*    */   public String getMsgId() {
/* 12 */     return this.msgId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\MQBaseDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */