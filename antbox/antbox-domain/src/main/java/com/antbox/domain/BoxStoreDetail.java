/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.BoxStoreDetailStatus;
/*     */ import com.antbox.domain.enumclass.QualityGuaranteePeriodType;
/*     */ import java.util.Date;
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
/*     */ @Table(name="t_box_store_detail", indexes={@javax.persistence.Index(name="box_store_detail_01", columnList="productId"), @javax.persistence.Index(name="box_store_detail_02", columnList="productLotno"), @javax.persistence.Index(name="box_store_detail_03", columnList="boxSerialNumber"), @javax.persistence.Index(name="box_store_detail_05", columnList="boxId")}, uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"rfid"})})
/*     */ @Entity
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class BoxStoreDetail
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '平台ID'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '产品ID'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="varchar(80) comment '产品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="varchar(100) comment '一体机标签'")
/*     */   private String rfid;
/*     */   @Column(columnDefinition="varchar(30) comment '批次号'")
/*     */   private String productLotno;
/*     */   @Column(columnDefinition="date comment '产品 生产日期'")
/*     */   private Date productionDate;
/*     */   @Column(columnDefinition="date comment '产品 过期日期'")
/*     */   private Date productExpiredDate;
/*     */   @Column(columnDefinition=" VARCHAR(10) comment '产品 保质期'")
/*     */   private String productQualityGuaranteePeriod;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(columnDefinition=" VARCHAR(20) comment '产品 保质期类型 DAY(0,\"日\"), MONTH(1,\"月\")'")
/*     */   private QualityGuaranteePeriodType productQualityGuaranteePeriodType;
/*     */   @Column(columnDefinition="bigint comment '售货机ID'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '售货机名称'")
/*     */   private String boxName;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '售货机编号'")
/*     */   private String boxSerialNumber;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '售货机详细具体地址'")
/*     */   private String boxAddressDetail;
/*     */   @Column(columnDefinition="bit default 0 comment '是否已售却还在售货机中(是:1,否:0)'")
/*     */   private Boolean sold;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(columnDefinition="VARCHAR(20) comment '状态 NORMAL(\"正常\"), SOLD(\"已出售\"),EXPIRED(\"已过期\"),EXPIRED_AND_SALED(\"过期且出售\")'")
/*     */   private BoxStoreDetailStatus boxStoreDetailStatus;
/*     */   
/*     */   public BoxStoreDetailStatus getBoxStoreDetailStatus()
/*     */   {
/*  71 */     return this.boxStoreDetailStatus;
/*     */   }
/*     */   
/*     */   public BoxStoreDetailStatus valBoxStoreDetailStatus() {
/*  75 */     if ((getSold().booleanValue()) && (getProductExpiredDate() != null) && (getProductExpiredDate().before(new Date()))) {
/*  76 */       return BoxStoreDetailStatus.EXPIRED_AND_SALED;
/*     */     }
/*  78 */     if (getSold().booleanValue()) {
/*  79 */       return BoxStoreDetailStatus.SOLD;
/*     */     }
/*  81 */     if ((getProductExpiredDate() != null) && (getProductExpiredDate().before(new Date()))) {
/*  82 */       return BoxStoreDetailStatus.EXPIRED;
/*     */     }
/*     */     
/*  85 */     return BoxStoreDetailStatus.NORMAL;
/*     */   }
/*     */   
/*     */   public void setBoxStoreDetailStatus(BoxStoreDetailStatus boxStoreDetailStatus) {
/*  89 */     this.boxStoreDetailStatus = boxStoreDetailStatus;
/*     */   }
/*     */   
/*     */   public String getProductLotno() {
/*  93 */     return this.productLotno;
/*     */   }
/*     */   
/*     */   public void setProductLotno(String productLotno) {
/*  97 */     this.productLotno = productLotno;
/*     */   }
/*     */   
/*     */   public Date getProductionDate() {
/* 101 */     return this.productionDate;
/*     */   }
/*     */   
/*     */   public void setProductionDate(Date productionDate) {
/* 105 */     this.productionDate = productionDate;
/*     */   }
/*     */   
/*     */   public Date getProductExpiredDate() {
/* 109 */     return this.productExpiredDate;
/*     */   }
/*     */   
/*     */   public void setProductExpiredDate(Date productExpiredDate) {
/* 113 */     this.productExpiredDate = productExpiredDate;
/*     */   }
/*     */   
/*     */   public String getProductQualityGuaranteePeriod() {
/* 117 */     return this.productQualityGuaranteePeriod;
/*     */   }
/*     */   
/*     */   public void setProductQualityGuaranteePeriod(String productQualityGuaranteePeriod) {
/* 121 */     this.productQualityGuaranteePeriod = productQualityGuaranteePeriod;
/*     */   }
/*     */   
/*     */   public QualityGuaranteePeriodType getProductQualityGuaranteePeriodType() {
/* 125 */     return this.productQualityGuaranteePeriodType;
/*     */   }
/*     */   
/*     */   public void setProductQualityGuaranteePeriodType(QualityGuaranteePeriodType productQualityGuaranteePeriodType) {
/* 129 */     this.productQualityGuaranteePeriodType = productQualityGuaranteePeriodType;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 133 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 137 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public String getBoxName() {
/* 141 */     return this.boxName;
/*     */   }
/*     */   
/*     */   public void setBoxName(String boxName) {
/* 145 */     this.boxName = boxName;
/*     */   }
/*     */   
/*     */   public String getBoxSerialNumber() {
/* 149 */     return this.boxSerialNumber;
/*     */   }
/*     */   
/*     */   public void setBoxSerialNumber(String boxSerialNumber) {
/* 153 */     this.boxSerialNumber = boxSerialNumber;
/*     */   }
/*     */   
/*     */   public String getBoxAddressDetail() {
/* 157 */     return this.boxAddressDetail;
/*     */   }
/*     */   
/*     */   public void setBoxAddressDetail(String boxAddressDetail) {
/* 161 */     this.boxAddressDetail = boxAddressDetail;
/*     */   }
/*     */   
/*     */   public Boolean getSold() {
/* 165 */     return this.sold;
/*     */   }
/*     */   
/*     */   public void setSold(Boolean sold) {
/* 169 */     this.sold = sold;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 173 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 177 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 181 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 185 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getProductId()
/*     */   {
/* 190 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/* 194 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/* 198 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 202 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getRfid() {
/* 206 */     return this.rfid;
/*     */   }
/*     */   
/*     */   public void setRfid(String rfid) {
/* 210 */     this.rfid = rfid;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxStoreDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */