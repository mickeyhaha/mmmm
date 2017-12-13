/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
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
/*     */ @Entity
/*     */ @Table(name="t_merchant_alipay_config")
/*     */ @DynamicUpdate
/*     */ @DynamicInsert
/*     */ @Where(clause="deleted = 0")
/*     */ public class MerchantAlipayConfig
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '平台商 id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商 id'", unique=true)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(100) comment '生活号appId'", unique=true)
/*     */   private String appId;
/*     */   @Column(columnDefinition="varchar(100) comment '商户openid'")
/*     */   private String openId;
/*     */   @Column(columnDefinition="varchar(2500) comment '支付宝应用私钥'")
/*     */   private String privateKey;
/*     */   @Column(columnDefinition="varchar(2500) comment '支付宝应用公钥'")
/*     */   private String publicKey;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝登录账号'")
/*     */   private String account;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝合作伙伴身份 id'")
/*     */   private String partnerId;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝合作伙伴身份 key'")
/*     */   private String partnerKey;
/*     */   
/*     */   public String getAccount()
/*     */   {
/*  44 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/*  48 */     this.account = account;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/*  52 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  56 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public String getAppId() {
/*  60 */     return this.appId;
/*     */   }
/*     */   
/*     */   public void setAppId(String appId) {
/*  64 */     this.appId = appId;
/*     */   }
/*     */   
/*     */   public String getPrivateKey() {
/*  68 */     return this.privateKey;
/*     */   }
/*     */   
/*     */   public void setPrivateKey(String privateKey) {
/*  72 */     this.privateKey = privateKey;
/*     */   }
/*     */   
/*     */   public String getPublicKey() {
/*  76 */     return this.publicKey;
/*     */   }
/*     */   
/*     */   public void setPublicKey(String publicKey) {
/*  80 */     this.publicKey = publicKey;
/*     */   }
/*     */   
/*     */   public String getOpenId() {
/*  84 */     return this.openId;
/*     */   }
/*     */   
/*     */   public void setOpenId(String openId) {
/*  88 */     this.openId = openId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  92 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  96 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getPartnerId() {
/* 100 */     return this.partnerId;
/*     */   }
/*     */   
/*     */   public void setPartnerId(String partnerId) {
/* 104 */     this.partnerId = partnerId;
/*     */   }
/*     */   
/*     */   public String getPartnerKey() {
/* 108 */     return this.partnerKey;
/*     */   }
/*     */   
/*     */   public void setPartnerKey(String partnerKey) {
/* 112 */     this.partnerKey = partnerKey;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MerchantAlipayConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */