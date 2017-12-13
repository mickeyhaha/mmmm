/*     */ package com.antbox.domain.store;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
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
/*     */ @Entity
/*     */ @Table(name="t_store_product_delivery_order")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class ProductDeliveryOrder
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(100) comment '出库单详情Id'", nullable=false)
/*     */   private String deliveryOrderId;
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
/*     */   @Column(name="merchant_id", columnDefinition="bigint COMMENT '运营商ID'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(name="box_id", columnDefinition="bigint COMMENT '售货机ID'", nullable=false)
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="int(2) COMMENT '上下架类型'", nullable=false)
/*     */   private DeliveryType type;
/*     */   @Column(columnDefinition="int(6) COMMENT '数量'", nullable=false)
/*     */   private Integer num;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '备注'")
/*     */   private String remark;
/*     */   
/*     */   public String getDeliveryOrderId()
/*     */   {
/*  57 */     return this.deliveryOrderId;
/*     */   }
/*     */   
/*     */   public void setDeliveryOrderId(String deliveryOrderId) {
/*  61 */     this.deliveryOrderId = deliveryOrderId;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  65 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  69 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Integer getProductNo() {
/*  73 */     return this.productNo;
/*     */   }
/*     */   
/*     */   public void setProductNo(Integer productNo) {
/*  77 */     this.productNo = productNo;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  81 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/*  85 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductUnit() {
/*  89 */     return this.productUnit;
/*     */   }
/*     */   
/*     */   public void setProductUnit(String productUnit) {
/*  93 */     this.productUnit = productUnit;
/*     */   }
/*     */   
/*     */   public Float getProductWeight() {
/*  97 */     return this.productWeight;
/*     */   }
/*     */   
/*     */   public void setProductWeight(Float productWeight) {
/* 101 */     this.productWeight = productWeight;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 105 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 109 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 113 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 117 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public DeliveryType getType() {
/* 121 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(DeliveryType type) {
/* 125 */     this.type = type;
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
/*     */   public String getRemark() {
/* 137 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 141 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\ProductDeliveryOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */