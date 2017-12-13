/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.CustomerPageStatus;
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
/*     */ @Entity
/*     */ @Table(name="t_customer_page_config")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class CustomerPageConfig
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String REMIND_MERCHANT_ID_IS_NOT_EXISTS = "未能得到运营商Id";
/*     */   public static final String REMIND_CONFIG_EXISTS_UNDER_MERCHANT = "该运营商已存在C端客户页面配置";
/*     */   public static final String REMIND_CONFIG_IS_NOT_UNDER_MERCHANT = "该C端客户页面配置不属于当前运营商";
/*     */   @Column(columnDefinition="BIGINT COMMENT '加盟商ID'", unique=true)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="int(2) comment '状态 DEFAULT(0, \"默认\"), CUSTOMIZE(1, \"自定义\")'")
/*     */   private CustomerPageStatus status;
/*     */   @Column(columnDefinition="VARCHAR(12) COMMENT '客服电话'")
/*     */   private String phone;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '支付宝首页标题'")
/*     */   private String alipayHomePageHeader;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '支付宝首页图片文件'")
/*     */   private String alipayHomePageImagePath;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '支付宝开门页图片文件'")
/*     */   private String alipayOpenedPageImagePath;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '微信首页标题'")
/*     */   private String weixinHomePageHeader;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '微信首页图片文件路径'")
/*     */   private String weixinHomePageImagePath;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '微信开门页图片文件路径'")
/*     */   private String weixinOpenedPageImagePath;
/*     */   
/*     */   public String getPhone()
/*     */   {
/*  52 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  56 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getAlipayHomePageImagePath() {
/*  60 */     return this.alipayHomePageImagePath;
/*     */   }
/*     */   
/*     */   public void setAlipayHomePageImagePath(String alipayHomePageImagePath) {
/*  64 */     this.alipayHomePageImagePath = alipayHomePageImagePath;
/*     */   }
/*     */   
/*     */   public String getAlipayOpenedPageImagePath() {
/*  68 */     return this.alipayOpenedPageImagePath;
/*     */   }
/*     */   
/*     */   public void setAlipayOpenedPageImagePath(String alipayOpenedPageImagePath) {
/*  72 */     this.alipayOpenedPageImagePath = alipayOpenedPageImagePath;
/*     */   }
/*     */   
/*     */   public String getWeixinHomePageHeader() {
/*  76 */     return this.weixinHomePageHeader;
/*     */   }
/*     */   
/*     */   public void setWeixinHomePageHeader(String weixinHomePageHeader) {
/*  80 */     this.weixinHomePageHeader = weixinHomePageHeader;
/*     */   }
/*     */   
/*     */   public String getWeixinHomePageImagePath() {
/*  84 */     return this.weixinHomePageImagePath;
/*     */   }
/*     */   
/*     */   public void setWeixinHomePageImagePath(String weixinHomePageImagePath) {
/*  88 */     this.weixinHomePageImagePath = weixinHomePageImagePath;
/*     */   }
/*     */   
/*     */   public String getWeixinOpenedPageImagePath() {
/*  92 */     return this.weixinOpenedPageImagePath;
/*     */   }
/*     */   
/*     */   public void setWeixinOpenedPageImagePath(String weixinOpenedPageImagePath) {
/*  96 */     this.weixinOpenedPageImagePath = weixinOpenedPageImagePath;
/*     */   }
/*     */   
/*     */   public CustomerPageStatus getStatus() {
/* 100 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(CustomerPageStatus status) {
/* 104 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 108 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 112 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getAlipayHomePageHeader() {
/* 116 */     return this.alipayHomePageHeader;
/*     */   }
/*     */   
/*     */   public void setAlipayHomePageHeader(String alipayHomePageHeader) {
/* 120 */     this.alipayHomePageHeader = alipayHomePageHeader;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\CustomerPageConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */