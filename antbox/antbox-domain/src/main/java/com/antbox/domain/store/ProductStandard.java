/*     */ package com.antbox.domain.store;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_store_product_standard", indexes={@javax.persistence.Index(name="product_id_index", columnList="product_id"), @javax.persistence.Index(name="box_id_index", columnList="box_id")})
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class ProductStandard
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '标准库存ID'")
/*     */   private Long boxStandId;
/*     */   @Column(name="box_id", columnDefinition="bigint comment '售货机ID'")
/*     */   private Long boxId;
/*     */   @Column(name="merchant_id", columnDefinition="bigint comment '运营商ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '平台商ID'")
/*     */   private Long mallId;
/*     */   @Column(name="product_id", columnDefinition="bigint COMMENT '商品ID'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '商品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="bigint COMMENT '类目ID'")
/*     */   private Long categoryId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '类目名称'")
/*     */   private String categoryName;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '商品单位'")
/*     */   private String productUnit;
/*     */   @Column(columnDefinition="FLOAT COMMENT '商品重量'")
/*     */   private Float productWeight;
/*     */   @Column(columnDefinition="int(5) COMMENT '数量'")
/*     */   private Integer num;
/*     */   
/*     */   public Long getCategoryId()
/*     */   {
/*  57 */     return this.categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(Long categoryId) {
/*  61 */     this.categoryId = categoryId;
/*     */   }
/*     */   
/*     */   public String getCategoryName() {
/*  65 */     return this.categoryName;
/*     */   }
/*     */   
/*     */   public void setCategoryName(String categoryName) {
/*  69 */     this.categoryName = categoryName;
/*     */   }
/*     */   
/*     */   public Long getBoxStandId() {
/*  73 */     return this.boxStandId;
/*     */   }
/*     */   
/*     */   public void setBoxStandId(Long boxStandId) {
/*  77 */     this.boxStandId = boxStandId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/*  81 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/*  85 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  89 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  93 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  97 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/* 101 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/* 105 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 109 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductUnit() {
/* 113 */     return this.productUnit;
/*     */   }
/*     */   
/*     */   public void setProductUnit(String productUnit) {
/* 117 */     this.productUnit = productUnit;
/*     */   }
/*     */   
/*     */   public Float getProductWeight() {
/* 121 */     return this.productWeight;
/*     */   }
/*     */   
/*     */   public void setProductWeight(Float productWeight) {
/* 125 */     this.productWeight = productWeight;
/*     */   }
/*     */   
/*     */   public Integer getNum() {
/* 129 */     return this.num;
/*     */   }
/*     */   
/*     */   public void setNum(Integer num) {
/* 133 */     this.num = num;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 137 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 141 */     this.mallId = mallId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\ProductStandard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */