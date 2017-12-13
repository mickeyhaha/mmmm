/*     */ package com.antbox.domain.store;
/*     */ 
/*     */ import com.antbox.common.CustomStringIDEntity;
/*     */ import com.antbox.domain.enumclass.BoxStoreType;
/*     */ import com.antbox.domain.enumclass.DeliveryOrderStatus;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
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
/*     */ @Table(name="t_store_delivery_order")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class DeliveryOrder
/*     */   extends CustomStringIDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint COMMENT '售货机ID'", nullable=false)
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '售货机名称'")
/*     */   private String boxName;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '售货机编号'")
/*     */   private String boxSerialNumber;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '售货机型号'")
/*     */   private String boxModelNumber;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '详细具体地址'")
/*     */   private String boxAddressDetail;
/*     */   @Column(columnDefinition="int(2) COMMENT '状态'", nullable=false)
/*     */   private DeliveryOrderStatus status;
/*     */   @Column(columnDefinition="int(2) COMMENT '类型'", nullable=false)
/*     */   private BoxStoreType type;
/*     */   @Column(columnDefinition="bigint COMMENT '补货员Id'")
/*     */   private Long deliveryUserId;
/*     */   @Column(columnDefinition="VARCHAR(255) COMMENT '补货员名称'")
/*     */   private String deliveryUserName;
/*     */   @Column(columnDefinition=" datetime comment '补货时间'")
/*     */   private Date deliveryDate;
/*     */   @Column(columnDefinition="bigint comment '出库单发起人id'")
/*     */   private Long creatorMerchantUserId;
/*     */   @Column(columnDefinition="varchar(15) comment '出库单发起人姓名'")
/*     */   private String creatorMerchantUserName;
/*     */   @Column(columnDefinition="bigint COMMENT '标准库存详情Id'")
/*     */   private Long storeStandardId;
/*     */   @Column(name="merchant_id", columnDefinition="bigint COMMENT '运营商ID'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="int(6) COMMENT '上架数量'")
/*     */   private Integer stockInNum;
/*     */   @Column(columnDefinition="int(6) COMMENT '下架数量'")
/*     */   private Integer stockOutNum;
/*     */   @Column(columnDefinition="varchar(15) comment '出库单发起人手机'")
/*     */   private String creatorMerchantUserPhone;
/*     */   @Column(columnDefinition="varchar(15) comment '补货员手机'")
/*     */   private String deliveryUserMobile;
/*     */   
/*     */   public String getCreatorMerchantUserPhone()
/*     */   {
/*  83 */     return this.creatorMerchantUserPhone;
/*     */   }
/*     */   
/*     */   public void setCreatorMerchantUserPhone(String creatorMerchantUserPhone) {
/*  87 */     this.creatorMerchantUserPhone = creatorMerchantUserPhone;
/*     */   }
/*     */   
/*     */   public String getDeliveryUserMobile() {
/*  91 */     return this.deliveryUserMobile;
/*     */   }
/*     */   
/*     */   public void setDeliveryUserMobile(String deliveryUserMobile) {
/*  95 */     this.deliveryUserMobile = deliveryUserMobile;
/*     */   }
/*     */   
/*     */   public Date getDeliveryDate() {
/*  99 */     return this.deliveryDate;
/*     */   }
/*     */   
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 103 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */   
/*     */   public String getBoxName() {
/* 107 */     return this.boxName;
/*     */   }
/*     */   
/*     */   public void setBoxName(String boxName) {
/* 111 */     this.boxName = boxName;
/*     */   }
/*     */   
/*     */   public String getBoxSerialNumber() {
/* 115 */     return this.boxSerialNumber;
/*     */   }
/*     */   
/*     */   public void setBoxSerialNumber(String boxSerialNumber) {
/* 119 */     this.boxSerialNumber = boxSerialNumber;
/*     */   }
/*     */   
/*     */   public String getBoxModelNumber() {
/* 123 */     return this.boxModelNumber;
/*     */   }
/*     */   
/*     */   public void setBoxModelNumber(String boxModelNumber) {
/* 127 */     this.boxModelNumber = boxModelNumber;
/*     */   }
/*     */   
/*     */   public String getBoxAddressDetail() {
/* 131 */     return this.boxAddressDetail;
/*     */   }
/*     */   
/*     */   public void setBoxAddressDetail(String boxAddressDetail) {
/* 135 */     this.boxAddressDetail = boxAddressDetail;
/*     */   }
/*     */   
/*     */   public Long getCreatorMerchantUserId() {
/* 139 */     return this.creatorMerchantUserId;
/*     */   }
/*     */   
/*     */   public void setCreatorMerchantUserId(Long creatorMerchantUserId) {
/* 143 */     this.creatorMerchantUserId = creatorMerchantUserId;
/*     */   }
/*     */   
/*     */   public String getCreatorMerchantUserName() {
/* 147 */     return this.creatorMerchantUserName;
/*     */   }
/*     */   
/*     */   public void setCreatorMerchantUserName(String creatorMerchantUserName) {
/* 151 */     this.creatorMerchantUserName = creatorMerchantUserName;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 155 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 159 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public DeliveryOrderStatus getStatus() {
/* 163 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(DeliveryOrderStatus status) {
/* 167 */     this.status = status;
/*     */   }
/*     */   
/*     */   public BoxStoreType getType() {
/* 171 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(BoxStoreType type) {
/* 175 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Long getDeliveryUserId() {
/* 179 */     return this.deliveryUserId;
/*     */   }
/*     */   
/*     */   public void setDeliveryUserId(Long deliveryUserId) {
/* 183 */     this.deliveryUserId = deliveryUserId;
/*     */   }
/*     */   
/*     */   public String getDeliveryUserName() {
/* 187 */     if (this.deliveryUserName != null) {
/*     */       try {
/* 189 */         return URLDecoder.decode(this.deliveryUserName, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
/*     */     }
/*     */     
/* 194 */     return this.deliveryUserName;
/*     */   }
/*     */   
/*     */   public void setDeliveryUserName(String deliveryUserName) {
/* 198 */     this.deliveryUserName = deliveryUserName;
/*     */   }
/*     */   
/*     */   public Long getStoreStandardId() {
/* 202 */     return this.storeStandardId;
/*     */   }
/*     */   
/*     */   public void setStoreStandardId(Long storeStandardId) {
/* 206 */     this.storeStandardId = storeStandardId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 210 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 214 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Integer getStockInNum() {
/* 218 */     return this.stockInNum;
/*     */   }
/*     */   
/*     */   public void setStockInNum(Integer stockInNum) {
/* 222 */     this.stockInNum = stockInNum;
/*     */   }
/*     */   
/*     */   public Integer getStockOutNum() {
/* 226 */     return this.stockOutNum;
/*     */   }
/*     */   
/*     */   public void setStockOutNum(Integer stockOutNum) {
/* 230 */     this.stockOutNum = stockOutNum;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\DeliveryOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */