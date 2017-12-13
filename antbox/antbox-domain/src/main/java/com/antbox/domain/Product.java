/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.ProductStatus;
/*     */ import com.antbox.domain.enumclass.QualityGuaranteePeriodType;
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
/*     */ @Entity
/*     */ @Table(name="t_product")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Product
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String CHECK_NAME_IS_NOT_NULL = "名称不能为空";
/*     */   public static final String CHECK_SALE_PRICE_IS_NOT_NULL = "销售价格不能为空";
/*     */   public static final String CHECK_COST_PRICE_IS_NOT_NULL = "成本价格不能为空";
/*     */   public static final String CHECK_MERCHANT_ID_IS_NOT_NULL = "加盟商ID不能为空";
/*     */   @Column(columnDefinition="VARCHAR(20) COMMENT '单位'")
/*     */   private String unit;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '品牌'")
/*     */   private String brand;
/*     */   @Column(columnDefinition="BIGINT COMMENT '加盟商ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="BIGINT COMMENT '平台ID'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="DECIMAL(20,2) COMMENT '成本价'")
/*     */   private BigDecimal costPrice;
/*     */   @Column(columnDefinition="DECIMAL(20,2) COMMENT '销售价格'")
/*     */   private BigDecimal salePrice;
/*     */   @Column(columnDefinition="FLOAT COMMENT '重量'")
/*     */   private Float weight;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="VARCHAR(50) NOT NULL DEFAULT 'ENABLE' COMMENT '状态 ENABLE(有效), DISABLE(无效)'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private ProductStatus status;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '旧系统产品id,数据迁移完成之后删除该字段'")
/*     */   private String oldProductId;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '第三方产品唯一标识'")
/*     */   private String partnerProductId;
/*     */   @Column(columnDefinition=" VARCHAR(10) comment '保质期'")
/*     */   private String qualityGuaranteePeriod;
/*     */   @Column(columnDefinition=" varchar(20) comment '保质期类型 DAY(0,\"日\"), MONTH(1,\"月\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private QualityGuaranteePeriodType qualityGuaranteePeriodType;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '商品编号'")
/*     */   private String productCode;
/*     */   @Column(columnDefinition="BIGINT NOT NULL COMMENT '类目ID'")
/*     */   private Long categoryId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '类目名称'")
/*     */   private String categoryName;
/*     */   
/*     */   public Product() {}
/*     */   
/*     */   public Product(Long id, String name)
/*     */   {
/*  71 */     super(id);
/*  72 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/*  76 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  80 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public ProductStatus getStatus() {
/*  84 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(ProductStatus status) {
/*  88 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  92 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  96 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getUnit() {
/* 100 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/* 104 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   public String getBrand() {
/* 108 */     return this.brand;
/*     */   }
/*     */   
/*     */   public void setBrand(String brand) {
/* 112 */     this.brand = brand;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 116 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 120 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public BigDecimal getCostPrice() {
/* 124 */     return this.costPrice;
/*     */   }
/*     */   
/*     */   public void setCostPrice(BigDecimal costPrice) {
/* 128 */     this.costPrice = costPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getSalePrice() {
/* 132 */     return this.salePrice;
/*     */   }
/*     */   
/*     */   public void setSalePrice(BigDecimal salePrice) {
/* 136 */     this.salePrice = salePrice;
/*     */   }
/*     */   
/*     */   public Float getWeight() {
/* 140 */     return this.weight;
/*     */   }
/*     */   
/*     */   public void setWeight(Float weight) {
/* 144 */     this.weight = weight;
/*     */   }
/*     */   
/*     */   public String getOldProductId() {
/* 148 */     return this.oldProductId;
/*     */   }
/*     */   
/*     */   public void setOldProductId(String oldProductId) {
/* 152 */     this.oldProductId = oldProductId;
/*     */   }
/*     */   
/*     */   public String getPartnerProductId() {
/* 156 */     return this.partnerProductId;
/*     */   }
/*     */   
/*     */   public void setPartnerProductId(String partnerProductId) {
/* 160 */     this.partnerProductId = partnerProductId;
/*     */   }
/*     */   
/*     */   public String getQualityGuaranteePeriod() {
/* 164 */     return this.qualityGuaranteePeriod;
/*     */   }
/*     */   
/*     */   public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
/* 168 */     this.qualityGuaranteePeriod = qualityGuaranteePeriod;
/*     */   }
/*     */   
/*     */   public QualityGuaranteePeriodType getQualityGuaranteePeriodType() {
/* 172 */     return this.qualityGuaranteePeriodType;
/*     */   }
/*     */   
/*     */   public void setQualityGuaranteePeriodType(QualityGuaranteePeriodType qualityGuaranteePeriodType) {
/* 176 */     this.qualityGuaranteePeriodType = qualityGuaranteePeriodType;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   public String getProductCode()
/*     */   {
/* 197 */     return this.productCode;
/*     */   }
/*     */   
/*     */   public void setProductCode(String productCode) {
/* 201 */     this.productCode = productCode;
/*     */   }
/*     */   
/*     */   public Long getCategoryId() {
/* 205 */     return this.categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(Long categoryId) {
/* 209 */     this.categoryId = categoryId;
/*     */   }
/*     */   
/*     */   public String getCategoryName() {
/* 213 */     return this.categoryName;
/*     */   }
/*     */   
/*     */   public void setCategoryName(String categoryName) {
/* 217 */     this.categoryName = categoryName;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Product.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */