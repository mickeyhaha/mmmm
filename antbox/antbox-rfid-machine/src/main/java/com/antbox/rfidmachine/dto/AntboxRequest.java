/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ import com.antbox.rfidmachine.helper.AntboxObject;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ public class AntboxRequest
/*    */   extends AntboxObject
/*    */ {
/*    */   public AntboxRequest(short command, short state, ByteBuf data)
/*    */   {
/* 12 */     super(command, data);
/* 13 */     this.status = state;
/*    */   }
/*    */   
/*    */   protected boolean hasCommand()
/*    */   {
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\AntboxRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */