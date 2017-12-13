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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_open_user")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class OpenUser
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '第三方用户UUID'")
/*     */   private String openId;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '第三方用户唯一凭证'")
/*     */   private String appId;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '第三方用户唯一凭证密钥'")
/*     */   private String appSecret;
/*     */   @Column(columnDefinition="VARCHAR(255) COMMENT '回调接口路径'")
/*     */   private String callBackUrl;
/*     */   @Column(columnDefinition="BIGINT COMMENT '开发者所属商家ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '用户名'")
/*     */   private String name;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '密码'")
/*     */   private String password;
/*     */   @Column(columnDefinition="BIGINT NOT NULL COMMENT 'accessToken过期时间'")
/*     */   private Long expireAt;
/*     */   @Column(columnDefinition="BIGINT COMMENT '开发者所属平台ID'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="varchar(50) comment '访问accessToken 生成规则 id + username + timestamp'", unique=true)
/*     */   private String accessToken;
/*     */   
/*     */   public String getOpenId()
/*     */   {
/*  53 */     return this.openId;
/*     */   }
/*     */   
/*     */   public void setOpenId(String openId) {
/*  57 */     this.openId = openId;
/*     */   }
/*     */   
/*     */   public String getAppId() {
/*  61 */     return this.appId;
/*     */   }
/*     */   
/*     */   public void setAppId(String appId) {
/*  65 */     this.appId = appId;
/*     */   }
/*     */   
/*     */   public String getAppSecret() {
/*  69 */     return this.appSecret;
/*     */   }
/*     */   
/*     */   public void setAppSecret(String appSecret) {
/*  73 */     this.appSecret = appSecret;
/*     */   }
/*     */   
/*     */   public String getCallBackUrl() {
/*  77 */     return this.callBackUrl;
/*     */   }
/*     */   
/*     */   public void setCallBackUrl(String callBackUrl) {
/*  81 */     this.callBackUrl = callBackUrl;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  85 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  89 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  93 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  97 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 101 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 105 */     this.password = password;
/*     */   }
/*     */   
/*     */   public Long getExpireAt() {
/* 109 */     return this.expireAt;
/*     */   }
/*     */   
/*     */   public void setExpireAt(Long expireAt) {
/* 113 */     this.expireAt = expireAt;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 117 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 121 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public String getAccessToken()
/*     */   {
/* 126 */     return this.accessToken;
/*     */   }
/*     */   
/*     */   public void setAccessToken(String accessToken)
/*     */   {
/* 131 */     this.accessToken = accessToken;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OpenUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */