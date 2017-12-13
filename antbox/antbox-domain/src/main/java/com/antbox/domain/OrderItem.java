/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.OrderItemRfidStatus;
/*     */ import com.antbox.domain.enumclass.OrderSource;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_order_item")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class OrderItem
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint not null comment '订单id'")
/*     */   private Long orderId;
/*     */   @Column(columnDefinition="bigint not null comment '订单号'")
/*     */   private Long orderNum;
/*     */   @Column(columnDefinition="bigint not null comment '平台id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint not null comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint not null comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="bigint(20) not null comment '商品id'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="bigint comment '客户id'")
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="varchar(20) comment '客户手机'")
/*     */   private String customerMobile;
/*     */   @Column(columnDefinition="varchar(50) not null comment '商品名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="smallint not null comment '购买数量'")
/*     */   private Integer amount;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '成本价'")
/*     */   private BigDecimal costPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '销售价格'")
/*     */   private BigDecimal salePrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '优惠'")
/*     */   private BigDecimal discountPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '实付总价格'")
/*     */   private BigDecimal payTotalPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '总价格'")
/*     */   private BigDecimal totalPrice;
/*     */   @Column(columnDefinition="varchar(3000) comment '产品对应rfid列表 数组方式'")
/*     */   private String rfidList;
/*     */   @Column(columnDefinition="int(2) not null comment 'rfid状态 COMMON(0,\"正常\"), SOLD(1,\"已售\")'")
/*     */   private OrderItemRfidStatus rfidStatus;
/*     */   @Column(columnDefinition="int(2) COMMENT '来源 ALIPAY_SHOPPING(1, \"支付宝用户购物\"),WECHAT_SHOPPING(2,\"微信用户购物\")'")
/*     */   private OrderSource source;
/*     */   @Column(columnDefinition="varchar(50) COMMENT '第三方产品唯一标识'")
/*     */   private String partnerProductId;
/*     */   @Column(columnDefinition="varchar(50) comment '第三方订单号唯一标识'")
/*     */   private String partnerOrderNum;
/*     */   
/*     */   public OrderSource getSource()
/*     */   {
/*  66 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(OrderSource source) {
/*  70 */     this.source = source;
/*     */   }
/*     */   
/*     */   public Long getOrderId() {
/*  74 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Long orderId) {
/*  78 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  82 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  86 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public Integer getAmount() {
/*  90 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Integer amount) {
/*  94 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public BigDecimal getDiscountPrice() {
/*  98 */     return this.discountPrice;
/*     */   }
/*     */   
/*     */   public void setDiscountPrice(BigDecimal discountPrice) {
/* 102 */     this.discountPrice = discountPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getPayTotalPrice() {
/* 106 */     return this.payTotalPrice;
/*     */   }
/*     */   
/*     */   public void setPayTotalPrice(BigDecimal payTotalPrice) {
/* 110 */     this.payTotalPrice = payTotalPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getCostPrice() {
/* 114 */     return this.costPrice;
/*     */   }
/*     */   
/*     */   public void setCostPrice(BigDecimal costPrice) {
/* 118 */     this.costPrice = costPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getSalePrice() {
/* 122 */     return this.salePrice;
/*     */   }
/*     */   
/*     */   public void setSalePrice(BigDecimal salePrice) {
/* 126 */     this.salePrice = salePrice;
/*     */   }
/*     */   
/*     */   public String getRfidList() {
/* 130 */     return this.rfidList;
/*     */   }
/*     */   
/*     */   public void setRfidList(String rfidList) {
/* 134 */     this.rfidList = rfidList;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPrice() {
/* 138 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(BigDecimal totalPrice) {
/* 142 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public OrderItemRfidStatus getRfidStatus() {
/* 146 */     return this.rfidStatus;
/*     */   }
/*     */   
/*     */   public void setRfidStatus(OrderItemRfidStatus rfidStatus) {
/* 150 */     this.rfidStatus = rfidStatus;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/* 154 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/* 158 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public Long getOrderNum() {
/* 162 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(Long orderNum) {
/* 166 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 170 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 174 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 178 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 182 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/* 186 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/* 190 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   public String getCustomerMobile() {
/* 194 */     return this.customerMobile;
/*     */   }
/*     */   
/*     */   public void setCustomerMobile(String customerMobile) {
/* 198 */     this.customerMobile = customerMobile;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 202 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 206 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public String getPartnerProductId() {
/* 210 */     return this.partnerProductId;
/*     */   }
/*     */   
/*     */   public void setPartnerProductId(String partnerProductId) {
/* 214 */     this.partnerProductId = partnerProductId;
/*     */   }
/*     */   
/*     */   public String getPartnerOrderNum() {
/* 218 */     return this.partnerOrderNum;
/*     */   }
/*     */   
/*     */   public void setPartnerOrderNum(String partnerOrderNum) {
/* 222 */     this.partnerOrderNum = partnerOrderNum;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */