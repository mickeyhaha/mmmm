/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
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
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_open_push_box_store")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class OpenPushBoxStore
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '商家id'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="BIGINT NOT NULL COMMENT '售货机ID'")
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="int comment '推送次数'")
/*    */   private Integer pushNum;
/*    */   @Column(columnDefinition="date comment '推送时间'")
/*    */   private String createTime;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 39 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 43 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 47 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 51 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 55 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 59 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public Integer getPushNum() {
/* 63 */     return this.pushNum;
/*    */   }
/*    */   
/*    */   public void setPushNum(Integer pushNum) {
/* 67 */     this.pushNum = pushNum;
/*    */   }
/*    */   
/*    */   public String getCreateTime() {
/* 71 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(String createTime) {
/* 75 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OpenPushBoxStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */