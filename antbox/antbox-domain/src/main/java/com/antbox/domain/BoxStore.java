/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.BoxStoreStatus;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
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
/*     */ @Table(name="t_box_store", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"box_id", "product_id"})}, indexes={@javax.persistence.Index(name="product_id_index", columnList="product_id"), @javax.persistence.Index(name="box_id_index", columnList="box_id")})
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class BoxStore
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String REMIND_BOX_ID_IS_NOT_NULL = "boxId不能为空";
/*     */   public static final String REMIND_PRODUCT_ID_IS_NOT_NULL = "productId不能为空";
/*     */   public static final String CHECK_ID_IS_NOT_NULL = "id不能为空";
/*     */   @Column(name="product_id", columnDefinition="BIGINT NOT NULL COMMENT '产品ID'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="varchar(80) comment '产品名称'")
/*     */   private String productName;
/*     */   @Column(name="box_id", columnDefinition="BIGINT NOT NULL COMMENT '售货机ID'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="SMALLINT default 0 COMMENT '标准库存数量 当 等于0 证明此产品没有设置标准库存，否则开启'")
/*     */   private Integer standardNum;
/*     */   @Column(columnDefinition="SMALLINT COMMENT '库存数量'")
/*     */   private Integer num;
/*     */   @Column(columnDefinition="BIGINT COMMENT '平台商ID'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="BIGINT NOT NULL COMMENT '加盟商ID'")
/*     */   private Long merchantId;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(columnDefinition="varchar(30) comment '状态 COMMON(0,\"正常\"),INVALID(1,\"无绑定标签\")'")
/*     */   private BoxStoreStatus status;
/*     */   @Column(columnDefinition="SMALLINT COMMENT '已售库存数量'")
/*     */   private Integer soldNum;
/*     */   @Column(columnDefinition="SMALLINT COMMENT '过期库存数量'")
/*     */   private Integer expiredNum;
/*     */   @Column(columnDefinition="SMALLINT COMMENT '过期且已售库存数量'")
/*     */   private Integer expiredAndSoldNum;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '产品类目'")
/*     */   private String categoryName;
/*     */   @Column(name="categoryId", columnDefinition="BIGINT COMMENT '产品类目ID'")
/*     */   private Long categoryId;
/*     */   @Column(columnDefinition="VARCHAR(20) COMMENT '单位'")
/*     */   private String productUnit;
/*     */   @Column(columnDefinition="FLOAT COMMENT '重量'")
/*     */   private Float productWeight;
/*     */   @Column(columnDefinition="DECIMAL(20,2) COMMENT '销售价格'")
/*     */   private BigDecimal productSalePrice;
/*     */   
/*     */   public Long getMallId()
/*     */   {
/*  75 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  79 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public BoxStoreStatus getStatus() {
/*  83 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(BoxStoreStatus status) {
/*  87 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  91 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  95 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  99 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 103 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/* 107 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/* 111 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 115 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 119 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public Integer getNum() {
/* 123 */     return this.num;
/*     */   }
/*     */   
/*     */   public void setNum(Integer num) {
/* 127 */     this.num = num;
/*     */   }
/*     */   
/*     */   public Integer getSoldNum() {
/* 131 */     return this.soldNum;
/*     */   }
/*     */   
/*     */   public void setSoldNum(Integer soldNum) {
/* 135 */     this.soldNum = soldNum;
/*     */   }
/*     */   
/*     */   public Integer getStandardNum() {
/* 139 */     return this.standardNum;
/*     */   }
/*     */   
/*     */   public void setStandardNum(Integer standardNum) {
/* 143 */     this.standardNum = standardNum;
/*     */   }
/*     */   
/*     */   public String getCategoryName() {
/* 147 */     return this.categoryName;
/*     */   }
/*     */   
/*     */   public void setCategoryName(String categoryName) {
/* 151 */     this.categoryName = categoryName;
/*     */   }
/*     */   
/*     */   public String getProductUnit() {
/* 155 */     return this.productUnit;
/*     */   }
/*     */   
/*     */   public void setProductUnit(String productUnit) {
/* 159 */     this.productUnit = productUnit;
/*     */   }
/*     */   
/*     */   public Float getProductWeight() {
/* 163 */     return this.productWeight;
/*     */   }
/*     */   
/*     */   public void setProductWeight(Float productWeight) {
/* 167 */     this.productWeight = productWeight;
/*     */   }
/*     */   
/*     */   public BigDecimal getProductSalePrice() {
/* 171 */     return this.productSalePrice;
/*     */   }
/*     */   
/*     */   public void setProductSalePrice(BigDecimal productSalePrice) {
/* 175 */     this.productSalePrice = productSalePrice;
/*     */   }
/*     */   
/*     */   public Long getCategoryId() {
/* 179 */     return this.categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(Long categoryId) {
/* 183 */     this.categoryId = categoryId;
/*     */   }
/*     */   
/*     */   public Integer getExpiredNum() {
/* 187 */     return this.expiredNum;
/*     */   }
/*     */   
/*     */   public void setExpiredNum(Integer expiredNum) {
/* 191 */     this.expiredNum = expiredNum;
/*     */   }
/*     */   
/*     */   public Integer getExpiredAndSoldNum() {
/* 195 */     return this.expiredAndSoldNum;
/*     */   }
/*     */   
/*     */   public void setExpiredAndSoldNum(Integer expiredAndSoldNum) {
/* 199 */     this.expiredAndSoldNum = expiredAndSoldNum;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */