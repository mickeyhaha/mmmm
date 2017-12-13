/*     */ package com.antbox.domain.store;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.BoxFloor;
/*     */ import com.antbox.domain.enumclass.DeliveryType;
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
/*     */ @Table(name="t_store_floor_delivery_order")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class FloorDeliveryOrder
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(50) comment '出库单详情Id'", nullable=false)
/*     */   private String deliveryOrderId;
/*     */   @Column(columnDefinition="int(2) COMMENT '售货机货架层号'", nullable=false)
/*     */   private BoxFloor floorNo;
/*     */   @Column(columnDefinition="bigint COMMENT '商品ID'", nullable=false)
/*     */   private Long productId;
/*     */   @Column(columnDefinition="int(5) COMMENT '商品顺序号'", nullable=false)
/*     */   private Integer productNo;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '商品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '商品单位'")
/*     */   private String productUnit;
/*     */   @Column(columnDefinition="FLOAT COMMENT '商品重量'")
/*     */   private Float productWeight;
/*     */   @Column(columnDefinition="int(5) COMMENT '标准库存数量'")
/*     */   private Integer standardFloorNum;
/*     */   @Column(columnDefinition="int(5) COMMENT '补货单数量'", nullable=false)
/*     */   private Integer deliveryFloorNum;
/*     */   @Column(columnDefinition="int(2) COMMENT '上下架类型'", nullable=false)
/*     */   private DeliveryType type;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '备注'")
/*     */   private String remark;
/*     */   @Column(name="merchant_id", columnDefinition="bigint COMMENT '运营商ID'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(name="box_id", columnDefinition="bigint COMMENT '售货机ID'", nullable=false)
/*     */   private Long boxId;
/*     */   
/*     */   public Integer getStandardFloorNum()
/*     */   {
/*  64 */     return this.standardFloorNum;
/*     */   }
/*     */   
/*     */   public void setStandardFloorNum(Integer standardFloorNum) {
/*  68 */     this.standardFloorNum = standardFloorNum;
/*     */   }
/*     */   
/*     */   public Integer getDeliveryFloorNum() {
/*  72 */     return this.deliveryFloorNum;
/*     */   }
/*     */   
/*     */   public void setDeliveryFloorNum(Integer deliveryFloorNum) {
/*  76 */     this.deliveryFloorNum = deliveryFloorNum;
/*     */   }
/*     */   
/*     */   public String getDeliveryOrderId() {
/*  80 */     return this.deliveryOrderId;
/*     */   }
/*     */   
/*     */   public void setDeliveryOrderId(String deliveryOrderId) {
/*  84 */     this.deliveryOrderId = deliveryOrderId;
/*     */   }
/*     */   
/*     */   public BoxFloor getFloorNo() {
/*  88 */     return this.floorNo;
/*     */   }
/*     */   
/*     */   public void setFloorNo(BoxFloor floorNo) {
/*  92 */     this.floorNo = floorNo;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  96 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/* 100 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Integer getProductNo() {
/* 104 */     return this.productNo;
/*     */   }
/*     */   
/*     */   public void setProductNo(Integer productNo) {
/* 108 */     this.productNo = productNo;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/* 112 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 116 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductUnit() {
/* 120 */     return this.productUnit;
/*     */   }
/*     */   
/*     */   public void setProductUnit(String productUnit) {
/* 124 */     this.productUnit = productUnit;
/*     */   }
/*     */   
/*     */   public Float getProductWeight() {
/* 128 */     return this.productWeight;
/*     */   }
/*     */   
/*     */   public void setProductWeight(Float productWeight) {
/* 132 */     this.productWeight = productWeight;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 136 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 140 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 144 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 148 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public DeliveryType getType() {
/* 152 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(DeliveryType type) {
/* 156 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/* 160 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 164 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\FloorDeliveryOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */