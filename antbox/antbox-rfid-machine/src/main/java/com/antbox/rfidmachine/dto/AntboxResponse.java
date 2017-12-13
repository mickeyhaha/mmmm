/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ import com.antbox.rfidmachine.helper.AntboxObject;
/*    */ import com.antbox.rfidmachine.util.AntboxUtil;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.math.BigInteger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AntboxResponse
/*    */   extends AntboxObject
/*    */ {
/*    */   private String selectMachine;
/*    */   private short dsfid;
/*    */   private String uid;
/*    */   
/*    */   public AntboxResponse(String selectMachine)
/*    */   {
/* 19 */     this.selectMachine = selectMachine;
/*    */   }
/*    */   
/*    */   public AntboxResponse(short command, short state, ByteBuf data) {
/* 23 */     super(command, data);
/* 24 */     this.status = state;
/*    */   }
/*    */   
/*    */   protected boolean hasCommand()
/*    */   {
/* 29 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setData(ByteBuf data)
/*    */   {
/* 36 */     if ("OLD_MACHINE_MODEL".equals(this.selectMachine)) {
/* 37 */       this.UID_BYTES_NUM = 8;
/*    */     }
/* 39 */     if ((data == null) || (data.readableBytes() <= 0)) {
/* 40 */       return;
/*    */     }
/* 42 */     this.dsfid = data.readUnsignedByte();
/* 43 */     byte[] uid0 = new byte[this.UID_BYTES_NUM];
/* 44 */     data.readBytes(uid0);
/* 45 */     String x = new BigInteger(1, uid0).toString(16).toUpperCase();
/* 46 */     this.uid = AntboxUtil.leftPad(x, 2 * this.UID_BYTES_NUM, '0');
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public short getDsfid()
/*    */   {
/* 56 */     return this.dsfid;
/*    */   }
/*    */   
/*    */   public void setDsfid(short dsfid) {
/* 60 */     this.dsfid = dsfid;
/*    */   }
/*    */   
/*    */   public String getUid() {
/* 64 */     return this.uid;
/*    */   }
/*    */   
/*    */   public void setUid(String uid) {
/* 68 */     this.uid = uid;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\AntboxResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */