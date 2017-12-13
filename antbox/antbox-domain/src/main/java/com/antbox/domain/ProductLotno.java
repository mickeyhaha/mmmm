/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import java.util.Date;
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
/*     */ @Entity
/*     */ @Table(name="t_product_lotno")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class ProductLotno
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(30) comment '批次号'", nullable=false)
/*     */   private String lotno;
/*     */   @Column(columnDefinition="bigint comment '产品ID'", nullable=false)
/*     */   private Long productId;
/*     */   @Column(columnDefinition="date comment '生产日期'")
/*     */   private Date productionDate;
/*     */   @Column(columnDefinition="date comment '过期日期'")
/*     */   private Date expiredDate;
/*     */   @Column(columnDefinition="bit default 0 comment '是否停用(是:1,否:0)'")
/*     */   private Boolean disabled;
/*     */   @Column(columnDefinition="varchar(50) comment '提示'")
/*     */   private String tips;
/*     */   @Column(columnDefinition="BIGINT COMMENT '加盟商ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="BIGINT COMMENT '平台ID'")
/*     */   private Long mallId;
/*     */   
/*     */   public String getLotno()
/*     */   {
/*  44 */     return this.lotno;
/*     */   }
/*     */   
/*     */   public void setLotno(String lotno) {
/*  48 */     this.lotno = lotno;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  52 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  56 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Boolean getDisabled() {
/*  60 */     return this.disabled;
/*     */   }
/*     */   
/*     */   public void setDisabled(Boolean disabled) {
/*  64 */     this.disabled = disabled;
/*     */   }
/*     */   
/*     */   public String getTips() {
/*  68 */     return this.tips;
/*     */   }
/*     */   
/*     */   public Date getProductionDate() {
/*  72 */     return this.productionDate;
/*     */   }
/*     */   
/*     */   public void setProductionDate(Date productionDate) {
/*  76 */     this.productionDate = productionDate;
/*     */   }
/*     */   
/*     */   public void setTips(String tips) {
/*  80 */     this.tips = tips;
/*     */   }
/*     */   
/*     */   public Date getExpiredDate() {
/*  84 */     return this.expiredDate;
/*     */   }
/*     */   
/*     */   public void setExpiredDate(Date expiredDate) {
/*  88 */     this.expiredDate = expiredDate;
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
/*     */   public Long getMallId() {
/* 100 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 104 */     this.mallId = mallId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\ProductLotno.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */