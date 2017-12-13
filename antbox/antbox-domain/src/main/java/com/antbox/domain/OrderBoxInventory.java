/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.OrderBoxInventoryHandleType;
/*     */ import com.antbox.domain.enumclass.OrderSource;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ @Entity
/*     */ @javax.persistence.Table(name="t_order_box_inventory")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class OrderBoxInventory extends IDEntity
/*     */ {
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(columnDefinition="varchar(30) comment '处理类型 WAIT(0, \"待处理\"), PROCESSED(1, \"已处理\"), IGNORE(2, \"忽略\")' ")
/*     */   private OrderBoxInventoryHandleType handleType;
/*     */   @Column(columnDefinition="TEXT comment '订单数据'")
/*     */   private String orderDataJson;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '订单总金额'")
/*     */   private BigDecimal totalPrice;
/*     */   @Column(columnDefinition="int(2) COMMENT '来源 ALIPAY_SHOPPING(1, \"支付宝用户购物\"),WECHAT_SHOPPING(2,\"微信用户购物\")'")
/*     */   private OrderSource source;
/*     */   @Column(columnDefinition="bigint comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="bigint comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '平台商id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="varchar(200) comment '售货机名称'")
/*     */   private String boxName;
/*     */   @Column(columnDefinition="varchar(200) comment '售货机 详细地址'")
/*     */   private String boxAddressDetail;
/*     */   @Column(columnDefinition="bigint comment '顾客id'")
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="varchar(20) comment '顾客手机号码'")
/*     */   private String customerMobile;
/*     */   
/*     */   public String getSourceText()
/*     */   {
/*  48 */     if (this.source != null) {
/*  49 */       return this.source.text;
/*     */     }
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public String getHandleTypeText() {
/*  55 */     if (this.handleType != null) {
/*  56 */       return this.handleType.text;
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */   
/*     */   public OrderBoxInventoryHandleType getHandleType() {
/*  62 */     return this.handleType;
/*     */   }
/*     */   
/*     */   public void setHandleType(OrderBoxInventoryHandleType handleType) {
/*  66 */     this.handleType = handleType;
/*     */   }
/*     */   
/*     */   public String getOrderDataJson() {
/*  70 */     return this.orderDataJson;
/*     */   }
/*     */   
/*     */   public void setOrderDataJson(String orderDataJson) {
/*  74 */     this.orderDataJson = orderDataJson;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPrice() {
/*  78 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(BigDecimal totalPrice) {
/*  82 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public OrderSource getSource() {
/*  86 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(OrderSource source) {
/*  90 */     this.source = source;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/*  94 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/*  98 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/* 102 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/* 106 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   public String getCustomerMobile() {
/* 110 */     return this.customerMobile;
/*     */   }
/*     */   
/*     */   public void setCustomerMobile(String customerMobile) {
/* 114 */     this.customerMobile = customerMobile;
/*     */   }
/*     */   
/*     */   public String getBoxName() {
/* 118 */     return this.boxName;
/*     */   }
/*     */   
/*     */   public void setBoxName(String boxName) {
/* 122 */     this.boxName = boxName;
/*     */   }
/*     */   
/*     */   public String getBoxAddressDetail() {
/* 126 */     return this.boxAddressDetail;
/*     */   }
/*     */   
/*     */   public void setBoxAddressDetail(String boxAddressDetail) {
/* 130 */     this.boxAddressDetail = boxAddressDetail;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 134 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 138 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 142 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 146 */     this.mallId = mallId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderBoxInventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */