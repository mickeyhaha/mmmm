/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.DistributionOperationType;
/*     */ import com.antbox.domain.enumclass.DistributionOrderItemRfidStatus;
/*     */ import java.math.BigDecimal;
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
/*     */ @Entity
/*     */ @Table(name="t_distribution_order_item")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class DistributionOrderItem
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '平台商id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(30) comment '加盟商名称'")
/*     */   private String merchantName;
/*     */   @Column(columnDefinition="bigint comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="varchar(30) comment '配货单号'")
/*     */   private String orderNum;
/*     */   @Column(columnDefinition="bigint comment '配货单id'")
/*     */   private Long orderId;
/*     */   @Column(columnDefinition="bigint comment '产品id'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="varchar(100) comment '产品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="DECIMAL(19,2) comment '产品成本价'")
/*     */   private BigDecimal productCostPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) comment '产品销售价'")
/*     */   private BigDecimal productSalePrice;
/*     */   @Column(columnDefinition="int(8) comment '产品数量'")
/*     */   private Integer amount;
/*     */   @Column(columnDefinition="DECIMAL(19,2) comment '总价'")
/*     */   private BigDecimal totalPrice;
/*     */   @Column(columnDefinition="int(2) comment '商品上下架操作 OFF(0, \"下架\"), ON(1, \"上架\")'")
/*     */   private DistributionOperationType operationType;
/*     */   @Column(columnDefinition="varchar(3000) comment 'rfid 列表 数组'")
/*     */   private String rfidList;
/*     */   @Column(columnDefinition="int(2) not null comment 'rfid状态 COMMON(0,\"正常\"), SOLD(1,\"已售\")'")
/*     */   private DistributionOrderItemRfidStatus rfidStatus;
/*     */   @Column(columnDefinition="varchar(30) COMMENT '第三方产品唯一标识'")
/*     */   private String partnerProductId;
/*     */   
/*     */   public DistributionOrderItemRfidStatus getRfidStatus()
/*     */   {
/*  60 */     return this.rfidStatus;
/*     */   }
/*     */   
/*     */   public void setRfidStatus(DistributionOrderItemRfidStatus rfidStatus) {
/*  64 */     this.rfidStatus = rfidStatus;
/*     */   }
/*     */   
/*     */   public DistributionOperationType getOperationType() {
/*  68 */     return this.operationType;
/*     */   }
/*     */   
/*     */   public void setOperationType(DistributionOperationType operationType) {
/*  72 */     this.operationType = operationType;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  76 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  80 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  84 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/*  88 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public BigDecimal getProductCostPrice() {
/*  92 */     return this.productCostPrice;
/*     */   }
/*     */   
/*     */   public void setProductCostPrice(BigDecimal productCostPrice) {
/*  96 */     this.productCostPrice = productCostPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getProductSalePrice() {
/* 100 */     return this.productSalePrice;
/*     */   }
/*     */   
/*     */   public void setProductSalePrice(BigDecimal productSalePrice) {
/* 104 */     this.productSalePrice = productSalePrice;
/*     */   }
/*     */   
/*     */   public Integer getAmount() {
/* 108 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Integer amount) {
/* 112 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPrice() {
/* 116 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(BigDecimal totalPrice) {
/* 120 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public Long getOrderId() {
/* 124 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Long orderId) {
/* 128 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 132 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 136 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 140 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 144 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getMerchantName() {
/* 148 */     return this.merchantName;
/*     */   }
/*     */   
/*     */   public void setMerchantName(String merchantName) {
/* 152 */     this.merchantName = merchantName;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 156 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 160 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public String getOrderNum() {
/* 164 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(String orderNum) {
/* 168 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public String getRfidList() {
/* 172 */     return this.rfidList;
/*     */   }
/*     */   
/*     */   public void setRfidList(String rfidList) {
/* 176 */     this.rfidList = rfidList;
/*     */   }
/*     */   
/*     */   public String getPartnerProductId() {
/* 180 */     return this.partnerProductId;
/*     */   }
/*     */   
/*     */   public void setPartnerProductId(String partnerProductId) {
/* 184 */     this.partnerProductId = partnerProductId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\DistributionOrderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */