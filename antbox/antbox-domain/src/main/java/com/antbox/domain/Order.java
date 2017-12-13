/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.OrderPayExceptionType;
/*     */ import com.antbox.domain.enumclass.OrderSource;
/*     */ import com.antbox.domain.enumclass.OrderStatus;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_order")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Order
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String CHECK_ORDER_NUM_IS_NOT_NULL = "orderNum 不能为空";
/*     */   public static final String ATTR_CLASS_NAME = "订单";
/*     */   @Column(columnDefinition="bigint comment '顾客id'")
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="varchar(20) comment '顾客手机号码'")
/*     */   private String customerMobile;
/*     */   @Column(columnDefinition="varchar(50) comment '订单号'")
/*     */   private Long orderNum;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '订单总金额'")
/*     */   private BigDecimal totalPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '订单优惠金额'")
/*     */   private BigDecimal discountTotalPrice;
/*     */   @Column(columnDefinition="varchar(255) COMMENT '订单优惠信息'")
/*     */   private String discountDescription;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '订单实付金额'")
/*     */   private BigDecimal payTotalPrice;
/*     */   @Column(columnDefinition="varchar(255) COMMENT '标题'")
/*     */   private String title;
/*     */   @Column(columnDefinition="int(2) COMMENT '状态 WAIT(0,\"待支付\"), SUCCESS(1,\"支付成功\"), FAIL(2,\"支付失败\")'")
/*     */   private OrderStatus status;
/*     */   @Column(columnDefinition="int(2) COMMENT '第三方支付平台 回调状态 WAIT(0,\"待支付\"), SUCCESS(1,\"支付成功\"), FAIL(2,\"支付失败\")'")
/*     */   private OrderStatus callBackStatus;
/*     */   @Column(columnDefinition="int(2) COMMENT '来源 ALIPAY_SHOPPING(1, \"支付宝用户购物\"),WECHAT_SHOPPING(2,\"微信用户购物\")'")
/*     */   private OrderSource source;
/*     */   @Column(columnDefinition="varchar(50) comment '外部订单号'")
/*     */   private String externalOrderNum;
/*     */   @Column(columnDefinition="bigint comment '平台商 id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="varchar(50) comment '平台商 名称'")
/*     */   private String mallName;
/*     */   @Column(columnDefinition="bigint comment '加盟商 id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(50) comment '加盟商 名称'")
/*     */   private String merchantName;
/*     */   @Column(columnDefinition="double comment '商家 分账比率'")
/*     */   private Double merchantSplitRate;
/*     */   @Column(columnDefinition="bigint comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="int(2) comment '支付异常类型 COMMON(0, \"正常\"),ALIPAY_CREATE_EXCEPTION_AGREEMENT_NOT_EXIST(1, \"调用支付宝创建订单异常，用户签约号不存在\"),ALIPAY_CREATE_EXCEPTION_ILLEGAL_ARGUMENT(2, \"调用支付宝创建订单异常，参数错误\")'")
/*     */   private OrderPayExceptionType payExceptionType;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '商户分账金额'")
/*     */   private BigDecimal merchantSplitPrice;
/*     */   @Column(columnDefinition="int(2) default 0 comment '支付失败后，重试次数'")
/*     */   private Integer payRetryCount;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '本订单蚂蚁盒子收入金额'")
/*     */   private BigDecimal incomePrice;
/*     */   @Column(columnDefinition="varchar(50) comment '第三方订单号唯一标识'")
/*     */   private String partnerOrderNum;
/*     */   @Column(columnDefinition="bigint comment '免密支付扣款 商家id，默认为 免密支付蚂蚁盒子id = 24'")
/*     */   private Long alipayFreePaymentMerchantId;
/*     */   
/*     */   public String getDiscountDescription()
/*     */   {
/*  80 */     return this.discountDescription;
/*     */   }
/*     */   
/*     */   public void setDiscountDescription(String discountDescription) {
/*  84 */     this.discountDescription = discountDescription;
/*     */   }
/*     */   
/*     */   public String getStatusText() {
/*  88 */     if (this.status != null) {
/*  89 */       return this.status.text;
/*     */     }
/*  91 */     return null;
/*     */   }
/*     */   
/*     */   public String getSourceText()
/*     */   {
/*  96 */     if (this.source != null) {
/*  97 */       return this.source.text;
/*     */     }
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public String getCustomerMobile() {
/* 103 */     return this.customerMobile;
/*     */   }
/*     */   
/*     */   public void setCustomerMobile(String customerMobile) {
/* 107 */     this.customerMobile = customerMobile;
/*     */   }
/*     */   
/*     */   public OrderStatus getCallBackStatus() {
/* 111 */     return this.callBackStatus;
/*     */   }
/*     */   
/*     */   public void setCallBackStatus(OrderStatus callBackStatus) {
/* 115 */     this.callBackStatus = callBackStatus;
/*     */   }
/*     */   
/*     */   public Double getMerchantSplitRate() {
/* 119 */     return this.merchantSplitRate;
/*     */   }
/*     */   
/*     */   public void setMerchantSplitRate(Double merchantSplitRate) {
/* 123 */     this.merchantSplitRate = merchantSplitRate;
/*     */   }
/*     */   
/*     */   public OrderPayExceptionType getPayExceptionType() {
/* 127 */     return this.payExceptionType;
/*     */   }
/*     */   
/*     */   public void setPayExceptionType(OrderPayExceptionType payExceptionType) {
/* 131 */     this.payExceptionType = payExceptionType;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 135 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 139 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 143 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 147 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getOrderNum() {
/* 151 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(Long orderNum) {
/* 155 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPrice() {
/* 159 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(BigDecimal totalPrice) {
/* 163 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getDiscountTotalPrice() {
/* 167 */     return this.discountTotalPrice;
/*     */   }
/*     */   
/*     */   public void setDiscountTotalPrice(BigDecimal discountTotalPrice) {
/* 171 */     this.discountTotalPrice = discountTotalPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getPayTotalPrice() {
/* 175 */     return this.payTotalPrice;
/*     */   }
/*     */   
/*     */   public void setPayTotalPrice(BigDecimal payTotalPrice) {
/* 179 */     this.payTotalPrice = payTotalPrice;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 183 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 187 */     this.title = title;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/* 191 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/* 195 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   public OrderSource getSource() {
/* 199 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(OrderSource source) {
/* 203 */     this.source = source;
/*     */   }
/*     */   
/*     */   public OrderStatus getStatus() {
/* 207 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(OrderStatus status) {
/* 211 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getExternalOrderNum() {
/* 215 */     return this.externalOrderNum;
/*     */   }
/*     */   
/*     */   public void setExternalOrderNum(String externalOrderNum) {
/* 219 */     this.externalOrderNum = externalOrderNum;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 223 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 227 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public BigDecimal getMerchantSplitPrice() {
/* 231 */     return this.merchantSplitPrice;
/*     */   }
/*     */   
/*     */   public void setMerchantSplitPrice(BigDecimal merchantSplitPrice) {
/* 235 */     this.merchantSplitPrice = merchantSplitPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getIncomePrice() {
/* 239 */     return this.incomePrice;
/*     */   }
/*     */   
/*     */   public void setIncomePrice(BigDecimal incomePrice) {
/* 243 */     this.incomePrice = incomePrice;
/*     */   }
/*     */   
/*     */   public String getMerchantName() {
/* 247 */     return this.merchantName;
/*     */   }
/*     */   
/*     */   public void setMerchantName(String merchantName) {
/* 251 */     this.merchantName = merchantName;
/*     */   }
/*     */   
/*     */   public String getMallName() {
/* 255 */     return this.mallName;
/*     */   }
/*     */   
/*     */   public void setMallName(String mallName) {
/* 259 */     this.mallName = mallName;
/*     */   }
/*     */   
/*     */   public Integer getPayRetryCount() {
/* 263 */     return this.payRetryCount;
/*     */   }
/*     */   
/*     */   public void setPayRetryCount(Integer payRetryCount) {
/* 267 */     this.payRetryCount = payRetryCount;
/*     */   }
/*     */   
/*     */   public String getPartnerOrderNum() {
/* 271 */     return this.partnerOrderNum;
/*     */   }
/*     */   
/*     */   public void setPartnerOrderNum(String partnerOrderNum) {
/* 275 */     this.partnerOrderNum = partnerOrderNum;
/*     */   }
/*     */   
/*     */   public Long getAlipayFreePaymentMerchantId() {
/* 279 */     return this.alipayFreePaymentMerchantId;
/*     */   }
/*     */   
/*     */   public void setAlipayFreePaymentMerchantId(Long alipayFreePaymentMerchantId) {
/* 283 */     this.alipayFreePaymentMerchantId = alipayFreePaymentMerchantId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Order.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */