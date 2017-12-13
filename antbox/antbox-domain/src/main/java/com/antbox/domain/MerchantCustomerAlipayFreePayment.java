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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_merchant_customer_alipay_free_payment")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class MerchantCustomerAlipayFreePayment
/*    */   extends IDEntity
/*    */ {
/*    */   public static final String ATTR_CLASS_NAME = "客户";
/*    */   @Column(columnDefinition="bigint comment '商家id'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="bigint comment '客户id'")
/*    */   private Long customerId;
/*    */   @Column(columnDefinition="varchar(50) comment '支付宝唯一用户id'")
/*    */   private String alipayUserId;
/*    */   @Column(columnDefinition="int(2) default 0 comment'支付宝免密支付协议 是否开通 1(\"是\"), 0(\"否\")'")
/*    */   private Boolean alipayFreePayment;
/*    */   @Column(columnDefinition="varchar(100) comment '支付宝免密支付协议 协议号'")
/*    */   private String alipayAgreementno;
/*    */   @Column(columnDefinition="varchar(50) comment '支付宝免密支付协议 签名时间'")
/*    */   private String alipayAgreementSignTime;
/*    */   
/*    */   public Long getMerchantId()
/*    */   {
/* 48 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 52 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Long getCustomerId() {
/* 56 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 60 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public String getAlipayUserId() {
/* 64 */     return this.alipayUserId;
/*    */   }
/*    */   
/*    */   public void setAlipayUserId(String alipayUserId) {
/* 68 */     this.alipayUserId = alipayUserId;
/*    */   }
/*    */   
/*    */   public Boolean getAlipayFreePayment() {
/* 72 */     return this.alipayFreePayment;
/*    */   }
/*    */   
/*    */   public void setAlipayFreePayment(Boolean alipayFreePayment) {
/* 76 */     this.alipayFreePayment = alipayFreePayment;
/*    */   }
/*    */   
/*    */   public String getAlipayAgreementno() {
/* 80 */     return this.alipayAgreementno;
/*    */   }
/*    */   
/*    */   public void setAlipayAgreementno(String alipayAgreementno) {
/* 84 */     this.alipayAgreementno = alipayAgreementno;
/*    */   }
/*    */   
/*    */   public String getAlipayAgreementSignTime() {
/* 88 */     return this.alipayAgreementSignTime;
/*    */   }
/*    */   
/*    */   public void setAlipayAgreementSignTime(String alipayAgreementSignTime) {
/* 92 */     this.alipayAgreementSignTime = alipayAgreementSignTime;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MerchantCustomerAlipayFreePayment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */