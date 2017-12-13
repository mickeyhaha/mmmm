/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ import com.antbox.domain.User;
/*    */ import com.antbox.rfidmachine.enumclass.SystemType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserDto
/*    */   extends User
/*    */ {
/*    */   private String domain;
/*    */   private SystemType systemType;
/*    */   private Long mallId;
/*    */   private Long merchantId;
/*    */   
/*    */   public String getDomain()
/*    */   {
/* 25 */     return this.domain;
/*    */   }
/*    */   
/*    */   public void setDomain(String domain) {
/* 29 */     this.domain = domain;
/*    */   }
/*    */   
/*    */   public SystemType getSystemType() {
/* 33 */     return this.systemType;
/*    */   }
/*    */   
/*    */   public void setSystemType(SystemType systemType) {
/* 37 */     this.systemType = systemType;
/*    */   }
/*    */   
/*    */   public Long getMallId() {
/* 41 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 45 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 49 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 53 */     this.merchantId = merchantId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\UserDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */