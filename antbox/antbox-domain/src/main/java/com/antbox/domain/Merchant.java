/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.BoxScanType;
/*     */ import com.antbox.domain.enumclass.MerchantStatus;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ @Table(name="t_merchant")
/*     */ @DynamicUpdate
/*     */ @DynamicInsert
/*     */ @Entity
/*     */ @Where(clause="deleted = 0")
/*     */ public class Merchant
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(12) comment '状态 ENABLE(\"启用\"), DISABLE(\"禁用\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private MerchantStatus status;
/*     */   @Column(columnDefinition="bigint comment '平台商 id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="varchar(100) comment '加盟商名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="varchar(100) comment '公司名称'")
/*     */   private String companyName;
/*     */   @Column(columnDefinition="varchar(100) comment '域名'", unique=true)
/*     */   private String domain;
/*     */   @Column(columnDefinition="varchar(200) comment '地址'")
/*     */   private String address;
/*     */   @Column(columnDefinition="double comment '分账费率'")
/*     */   private Double splitRate;
/*     */   @Column(columnDefinition="varchar(500) comment '加盟商logo地址'")
/*     */   private String logoUrl;
/*     */   @Column(columnDefinition="varchar(20) comment '客服电话'")
/*     */   private String customerServicePhone;
/*     */   @Column(columnDefinition="bigint comment ''")
/*     */   private Long oldMerchantId;
/*     */   @Column(columnDefinition="varchar(30) comment '扫码支持类型 WECHAT(\"微信\"), ALIPAY(\"支付宝\"), ALL(\"全部\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private BoxScanType scanType;
/*     */   @Column(columnDefinition="bit default 0 comment '是否使用商家服务窗'")
/*     */   private Boolean isAlipayServiceWindow;
/*     */   @Column(columnDefinition="bit default 0 comment '是否使用商家支付宝免密支付'")
/*     */   private Boolean isAlipayFreePayment;
/*     */   @Column(columnDefinition="bit default 0 comment '是否使用商家微信免密支付'")
/*     */   private Boolean isWechatFreePayment;
/*     */   @Column(columnDefinition="bit default 0 comment '是否开通第三方'")
/*     */   private Boolean isOpenPartner;
/*     */   
/*     */   public String getCustomerServicePhone()
/*     */   {
/*  58 */     return this.customerServicePhone;
/*     */   }
/*     */   
/*     */   public void setCustomerServicePhone(String customerServicePhone) {
/*  62 */     this.customerServicePhone = customerServicePhone;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  66 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  70 */     this.address = address;
/*     */   }
/*     */   
/*     */   public MerchantStatus getStatus() {
/*  74 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(MerchantStatus status) {
/*  78 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/*  82 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  86 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  90 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  94 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/*  98 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/* 102 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getDomain() {
/* 106 */     return this.domain;
/*     */   }
/*     */   
/*     */   public void setDomain(String domain) {
/* 110 */     this.domain = domain;
/*     */   }
/*     */   
/*     */   public Double getSplitRate() {
/* 114 */     return this.splitRate;
/*     */   }
/*     */   
/*     */   public void setSplitRate(Double splitRate) {
/* 118 */     this.splitRate = splitRate;
/*     */   }
/*     */   
/*     */   public String getLogoUrl() {
/* 122 */     return this.logoUrl;
/*     */   }
/*     */   
/*     */   public void setLogoUrl(String logoUrl) {
/* 126 */     this.logoUrl = logoUrl;
/*     */   }
/*     */   
/*     */   public Long getOldMerchantId() {
/* 130 */     return this.oldMerchantId;
/*     */   }
/*     */   
/*     */   public void setOldMerchantId(Long oldMerchantId) {
/* 134 */     this.oldMerchantId = oldMerchantId;
/*     */   }
/*     */   
/*     */   public BoxScanType getScanType() {
/* 138 */     return this.scanType;
/*     */   }
/*     */   
/*     */   public void setScanType(BoxScanType scanType) {
/* 142 */     this.scanType = scanType;
/*     */   }
/*     */   
/*     */   public Boolean getAlipayFreePayment() {
/* 146 */     return this.isAlipayFreePayment;
/*     */   }
/*     */   
/*     */   public void setAlipayFreePayment(Boolean alipayFreePayment) {
/* 150 */     this.isAlipayFreePayment = alipayFreePayment;
/*     */   }
/*     */   
/*     */   public Boolean getWechatFreePayment() {
/* 154 */     return this.isWechatFreePayment;
/*     */   }
/*     */   
/*     */   public void setWechatFreePayment(Boolean wechatFreePayment) {
/* 158 */     this.isWechatFreePayment = wechatFreePayment;
/*     */   }
/*     */   
/*     */   public Boolean getOpenPartner() {
/* 162 */     return this.isOpenPartner;
/*     */   }
/*     */   
/*     */   public void setOpenPartner(Boolean openPartner) {
/* 166 */     this.isOpenPartner = openPartner;
/*     */   }
/*     */   
/*     */   public Boolean getAlipayServiceWindow() {
/* 170 */     return this.isAlipayServiceWindow;
/*     */   }
/*     */   
/*     */   public void setAlipayServiceWindow(Boolean alipayServiceWindow) {
/* 174 */     this.isAlipayServiceWindow = alipayServiceWindow;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Merchant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */