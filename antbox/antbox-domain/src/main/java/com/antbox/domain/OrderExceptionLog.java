/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.OrderExceptionLogType;
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
/*     */ @Table(name="t_order_exception_log")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class OrderExceptionLog
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '订单id'")
/*     */   private Long orderId;
/*     */   @Column(columnDefinition="varchar(50) comment '订单号'")
/*     */   private Long orderNum;
/*     */   @Column(columnDefinition="varchar(50) comment '日志标题'")
/*     */   private String title;
/*     */   @Column(columnDefinition="varchar(5000) comment '内容'")
/*     */   private String content;
/*     */   @Column(columnDefinition="smallint(2) comment '类型 COMMON(0, \"正常\"), ALIPAY_CREATE_EXCEPTION(1, \"调用支付宝创建订单异常\"), ALIPAY_CALLBACK_EXCEPTION(3, \"支付宝回调异常\"), RFID_SOLD(4, \"rfid产品已售异常\"),  RFID_PRODUCT_IS_NOT_EXIST(5, \"rfid对应产品不存在\"), CODE_EXCEPTION(6, \"代码异常\"), ALIPAY_OPENID_IS_NULL(7, \"商家openid为空\")'")
/*     */   private OrderExceptionLogType type;
/*     */   @Column(columnDefinition="varchar(5000) comment '订单请求json'")
/*     */   private String data;
/*     */   @Column(columnDefinition="bigint comment '平台id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   
/*     */   public String getTypeText()
/*     */   {
/*  42 */     if (this.type != null) {
/*  43 */       return this.type.text;
/*     */     }
/*  45 */     return null;
/*     */   }
/*     */   
/*     */   public Long getMallId()
/*     */   {
/*  50 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/*  54 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  58 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  62 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  66 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  70 */     this.title = title;
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
/*     */   public Long getOrderNum() {
/*  82 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(Long orderNum) {
/*  86 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public String getContent() {
/*  90 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/*  94 */     this.content = content;
/*     */   }
/*     */   
/*     */   public OrderExceptionLogType getType() {
/*  98 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(OrderExceptionLogType type) {
/* 102 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getData() {
/* 106 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(String data) {
/* 110 */     this.data = data;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderExceptionLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */