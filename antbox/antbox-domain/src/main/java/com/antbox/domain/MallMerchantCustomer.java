/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.CustomerRegisterSource;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_mall_merchant_customer", indexes={@javax.persistence.Index(name="first_order_status_index", columnList="first_order_status")}, uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"mallId", "merchantId", "customerId", "alipayFreePaymentMerchantId"}), @javax.persistence.UniqueConstraint(columnNames={"mallId", "merchantId", "alipayUserId", "alipayFreePaymentMerchantId"})})
/*     */ @DynamicUpdate
/*     */ @DynamicInsert
/*     */ @Where(clause="deleted = 0")
/*     */ public class MallMerchantCustomer
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '平台商 id'", nullable=false)
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商 id'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '用户 id'", nullable=false)
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="bit default 0 comment '是否补货员 1(\"是\"), 0(\"否\")'", name="is_distribution")
/*     */   private Boolean distribution;
/*     */   @Column(columnDefinition="bit default 0 comment '是否首单 1(\"是\"), 0(\"否\")'", name="first_order_status")
/*     */   private Boolean firstOrderStatus;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝唯一用户id'", unique=true)
/*     */   private String alipayUserId;
/*     */   @Column(columnDefinition="int(2) default 0 comment'支付宝免密支付协议 是否开通 1(\"是\"), 0(\"否\")'")
/*     */   private Boolean alipayFreePayment;
/*     */   @Column(columnDefinition="varchar(100) comment '支付宝免密支付协议 协议号'")
/*     */   private String alipayAgreementno;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝免密支付协议 签名时间'")
/*     */   private String alipayAgreementSignTime;
/*     */   @Column(columnDefinition="varchar(50) comment '微信 服务号 openid'")
/*     */   private String wechatOpenId;
/*     */   @Column(columnDefinition="bit default 0 comment'微信 免密支付协议 是否开通 1(\"是\"), 0(\"否\")'")
/*     */   private Boolean wechatFreePayment;
/*     */   @Column(columnDefinition="varchar(50) comment '微信 签约协议号'")
/*     */   private String wechatAgreementno;
/*     */   @Column(columnDefinition="varchar(20) comment '首次注册售货机id'")
/*     */   private Long registerBoxId;
/*     */   @Column(columnDefinition="int(2) comment '首次注册来源 ALIPAY(0, \"支付宝\"), WECHAT(1, \"微信\"), THIRD_PARTY_APP(2, \"第三方\")'")
/*     */   private CustomerRegisterSource registerSource;
/*     */   @Column(columnDefinition="bigint comment '免密支付签约所属商家id'")
/*     */   private Long alipayFreePaymentMerchantId;
/*     */   
/*     */   public Boolean getFirstOrderStatus()
/*     */   {
/*  63 */     return this.firstOrderStatus;
/*     */   }
/*     */   
/*     */   public void setFirstOrderStatus(Boolean firstOrderStatus) {
/*  67 */     this.firstOrderStatus = firstOrderStatus;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/*  71 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  75 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId()
/*     */   {
/*  80 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  84 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/*  88 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/*  92 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   public Boolean getDistribution() {
/*  96 */     return this.distribution;
/*     */   }
/*     */   
/*     */   public void setDistribution(Boolean distribution) {
/* 100 */     this.distribution = distribution;
/*     */   }
/*     */   
/*     */   public String getAlipayUserId() {
/* 104 */     return this.alipayUserId;
/*     */   }
/*     */   
/*     */   public void setAlipayUserId(String alipayUserId) {
/* 108 */     this.alipayUserId = alipayUserId;
/*     */   }
/*     */   
/*     */   public Boolean getAlipayFreePayment() {
/* 112 */     return this.alipayFreePayment;
/*     */   }
/*     */   
/*     */   public void setAlipayFreePayment(Boolean alipayFreePayment) {
/* 116 */     this.alipayFreePayment = alipayFreePayment;
/*     */   }
/*     */   
/*     */   public String getAlipayAgreementno() {
/* 120 */     return this.alipayAgreementno;
/*     */   }
/*     */   
/*     */   public void setAlipayAgreementno(String alipayAgreementno) {
/* 124 */     this.alipayAgreementno = alipayAgreementno;
/*     */   }
/*     */   
/*     */   public String getAlipayAgreementSignTime() {
/* 128 */     return this.alipayAgreementSignTime;
/*     */   }
/*     */   
/*     */   public void setAlipayAgreementSignTime(String alipayAgreementSignTime) {
/* 132 */     this.alipayAgreementSignTime = alipayAgreementSignTime;
/*     */   }
/*     */   
/*     */   public Long getRegisterBoxId() {
/* 136 */     return this.registerBoxId;
/*     */   }
/*     */   
/*     */   public void setRegisterBoxId(Long registerBoxId) {
/* 140 */     this.registerBoxId = registerBoxId;
/*     */   }
/*     */   
/*     */   public CustomerRegisterSource getRegisterSource() {
/* 144 */     return this.registerSource;
/*     */   }
/*     */   
/*     */   public void setRegisterSource(CustomerRegisterSource registerSource) {
/* 148 */     this.registerSource = registerSource;
/*     */   }
/*     */   
/*     */   public String getWechatOpenId() {
/* 152 */     return this.wechatOpenId;
/*     */   }
/*     */   
/*     */   public void setWechatOpenId(String wechatOpenId) {
/* 156 */     this.wechatOpenId = wechatOpenId;
/*     */   }
/*     */   
/*     */   public Boolean getWechatFreePayment() {
/* 160 */     return this.wechatFreePayment;
/*     */   }
/*     */   
/*     */   public void setWechatFreePayment(Boolean wechatFreePayment) {
/* 164 */     this.wechatFreePayment = wechatFreePayment;
/*     */   }
/*     */   
/*     */   public String getWechatAgreementno() {
/* 168 */     return this.wechatAgreementno;
/*     */   }
/*     */   
/*     */   public void setWechatAgreementno(String wechatAgreementno) {
/* 172 */     this.wechatAgreementno = wechatAgreementno;
/*     */   }
/*     */   
/*     */   public Long getAlipayFreePaymentMerchantId() {
/* 176 */     return this.alipayFreePaymentMerchantId;
/*     */   }
/*     */   
/*     */   public void setAlipayFreePaymentMerchantId(Long alipayFreePaymentMerchantId) {
/* 180 */     this.alipayFreePaymentMerchantId = alipayFreePaymentMerchantId;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 185 */     return "MallMerchantCustomer{id=" + this.id + ", mallId=" + this.mallId + ", merchantId=" + this.merchantId + ", customerId=" + this.customerId + ", distribution=" + this.distribution + ", firstOrderStatus=" + this.firstOrderStatus + ", alipayUserId='" + this.alipayUserId + '\'' + ", alipayFreePayment=" + this.alipayFreePayment + ", alipayAgreementno='" + this.alipayAgreementno + '\'' + ", alipayAgreementSignTime='" + this.alipayAgreementSignTime + '\'' + ", wechatOpenId='" + this.wechatOpenId + '\'' + ", wechatFreePayment=" + this.wechatFreePayment + ", wechatAgreementno='" + this.wechatAgreementno + '\'' + ", registerBoxId=" + this.registerBoxId + ", registerSource=" + this.registerSource + ", alipayFreePaymentMerchantId=" + this.alipayFreePaymentMerchantId + '}';
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MallMerchantCustomer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */