/*     */ package com.antbox.domain.store;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.BoxFloor;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_store_floor_standard")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class FloorStandard
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '标准库存ID'", nullable=false)
/*     */   private Long boxStandId;
/*     */   @Column(name="floor_no", columnDefinition="int(2) COMMENT '售货机货架层号'", nullable=false)
/*     */   private BoxFloor floorNo;
/*     */   @Column(name="product_id", columnDefinition="bigint COMMENT '商品ID'", nullable=false)
/*     */   private Long productId;
/*     */   @Column(name="product_no", columnDefinition="int(5) COMMENT '商品顺序号'", nullable=false)
/*     */   private Integer productNo;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '商品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '商品单位'")
/*     */   private String productUnit;
/*     */   @Column(columnDefinition="FLOAT COMMENT '商品重量'")
/*     */   private Float productWeight;
/*     */   @Column(columnDefinition="bigint COMMENT '类目ID'")
/*     */   private Long categoryId;
/*     */   @Column(name="box_id", columnDefinition="bigint COMMENT '售货机ID'", nullable=false)
/*     */   private Long boxId;
/*     */   @Column(name="merchant_id", columnDefinition="bigint COMMENT '运营商ID'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint COMMENT '平台商ID'", nullable=false)
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '商品类目名称'")
/*     */   private String categoryName;
/*     */   @Column(columnDefinition="int(5) COMMENT '数量'", nullable=false)
/*     */   private Integer num;
/*     */   
/*     */   public Long getMerchantId()
/*     */   {
/*  63 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  67 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/*  71 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/*  75 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public Long getCategoryId() {
/*  79 */     return this.categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(Long categoryId) {
/*  83 */     this.categoryId = categoryId;
/*     */   }
/*     */   
/*     */   public String getCategoryName() {
/*  87 */     return this.categoryName;
/*     */   }
/*     */   
/*     */   public void setCategoryName(String categoryName) {
/*  91 */     this.categoryName = categoryName;
/*     */   }
/*     */   
/*     */   public Long getBoxStandId() {
/*  95 */     return this.boxStandId;
/*     */   }
/*     */   
/*     */   public void setBoxStandId(Long boxStandId) {
/*  99 */     this.boxStandId = boxStandId;
/*     */   }
/*     */   
/*     */   public BoxFloor getFloorNo() {
/* 103 */     return this.floorNo;
/*     */   }
/*     */   
/*     */   public void setFloorNo(BoxFloor floorNo) {
/* 107 */     this.floorNo = floorNo;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/* 111 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/* 115 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Integer getProductNo() {
/* 119 */     return this.productNo;
/*     */   }
/*     */   
/*     */   public void setProductNo(Integer productNo) {
/* 123 */     this.productNo = productNo;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/* 127 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 131 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductUnit() {
/* 135 */     return this.productUnit;
/*     */   }
/*     */   
/*     */   public void setProductUnit(String productUnit) {
/* 139 */     this.productUnit = productUnit;
/*     */   }
/*     */   
/*     */   public Float getProductWeight() {
/* 143 */     return this.productWeight;
/*     */   }
/*     */   
/*     */   public void setProductWeight(Float productWeight) {
/* 147 */     this.productWeight = productWeight;
/*     */   }
/*     */   
/*     */   public Integer getNum() {
/* 151 */     return this.num;
/*     */   }
/*     */   
/*     */   public void setNum(Integer num) {
/* 155 */     this.num = num;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 159 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 163 */     this.mallId = mallId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\FloorStandard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */