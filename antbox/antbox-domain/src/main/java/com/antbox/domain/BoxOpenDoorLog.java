/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.BoxOpenDoorType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_box_open_door_log")
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class BoxOpenDoorLog
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '售货机id'")
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="bigint comment '客户id'")
/*    */   private Long customerId;
/*    */   @Column(columnDefinition="smallint comment '类型 COMMON(0,\"购物\"), DISTRIBUTION(1,\"补货\")'")
/*    */   private BoxOpenDoorType type;
/*    */   @Column(columnDefinition="bigint comment '开门时间'")
/*    */   private Long openTime;
/*    */   @Column(columnDefinition="bigint comment '关门时间'")
/*    */   private Long closeTime;
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '加盟商id'")
/*    */   private Long merchantId;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 42 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 46 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 50 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 54 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Long getOpenTime() {
/* 58 */     return this.openTime;
/*    */   }
/*    */   
/*    */   public void setOpenTime(Long openTime) {
/* 62 */     this.openTime = openTime;
/*    */   }
/*    */   
/*    */   public Long getCloseTime() {
/* 66 */     return this.closeTime;
/*    */   }
/*    */   
/*    */   public void setCloseTime(Long closeTime) {
/* 70 */     this.closeTime = closeTime;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 74 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 78 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public Long getCustomerId() {
/* 82 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 86 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public BoxOpenDoorType getType() {
/* 90 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(BoxOpenDoorType type) {
/* 94 */     this.type = type;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxOpenDoorLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */