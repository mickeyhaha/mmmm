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
/*    */ @Entity
/*    */ @Table(name="t_open_push_customer")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class OpenPushCustomer
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '商家id'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="int comment '推送次数'")
/*    */   private Integer pushNum;
/*    */   @Column(columnDefinition="bigint comment '用户id'")
/*    */   private Long customerId;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 35 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 39 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 43 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 47 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Integer getPushNum() {
/* 51 */     return this.pushNum;
/*    */   }
/*    */   
/*    */   public void setPushNum(Integer pushNum) {
/* 55 */     this.pushNum = pushNum;
/*    */   }
/*    */   
/*    */   public Long getCustomerId() {
/* 59 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 63 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 68 */     return "OpenPushCustomer{mallId=" + this.mallId + ", merchantId=" + this.merchantId + ", pushNum=" + this.pushNum + ", customerId=" + this.customerId + '}';
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OpenPushCustomer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */