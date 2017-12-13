/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.common.Whether;
/*     */ import com.antbox.domain.enumclass.UserStatus;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ @Table(name="t_merchant_user")
/*     */ @DynamicUpdate
/*     */ @DynamicInsert
/*     */ @Entity
/*     */ @Where(clause="deleted = 0")
/*     */ public class MerchantUser
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '用户 id'")
/*     */   private Long userId;
/*     */   @Column(columnDefinition="bigint comment '平台商 id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商 id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(20) comment '是否超级管理员  YES(\"是\"), NO(\"否\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private Whether isAdmin;
/*     */   @Column(columnDefinition="int(1)  NOT NULL DEFAULT 0  comment '是否拥有所有盒子权限 1(true)/0(false)'")
/*     */   private Boolean hasAllBox;
/*     */   @Column(columnDefinition="varchar(15) comment '用户名'")
/*     */   private String name;
/*     */   @Column(columnDefinition="bigint comment '补货员 对应的customerId'")
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="varchar(12) comment '状态 ENABLE(\"启用\"), DISABLE(\"禁用\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private UserStatus status;
/*     */   
/*     */   public UserStatus getStatus()
/*     */   {
/*  44 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(UserStatus status) {
/*  48 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  52 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  56 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/*  60 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  64 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/*  68 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  72 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  76 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  80 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Whether getIsAdmin() {
/*  84 */     return this.isAdmin;
/*     */   }
/*     */   
/*     */   public void setIsAdmin(Whether isAdmin) {
/*  88 */     this.isAdmin = isAdmin;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/*  92 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/*  96 */     this.customerId = customerId;
/*     */   }
/*     */   
/*  99 */   public Boolean getHasAllBox() { return this.hasAllBox; }
/*     */   
/* 101 */   public void setHasAllBox(Boolean hasAllBox) { this.hasAllBox = hasAllBox; }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MerchantUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */