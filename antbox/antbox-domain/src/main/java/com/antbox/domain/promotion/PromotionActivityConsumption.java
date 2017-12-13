/*     */ package com.antbox.domain.promotion;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.PromotionActivityConsumptionStatus;
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
/*     */ @Table(name="t_promotion_activity_consumption")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class PromotionActivityConsumption
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment '用户id'")
/*     */   private Long customerId;
/*     */   @Column(columnDefinition="bigint(50) comment '订单Id'")
/*     */   private Long orderId;
/*     */   @Column(columnDefinition="varchar(255) comment '订单号'")
/*     */   private Long orderNum;
/*     */   @Column(columnDefinition="bigint comment '加盟商 id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '促销活动id'")
/*     */   private Long promotionActivityId;
/*     */   @Column(columnDefinition="int(2) comment '状态 USED(1,\"已用\"), ROLLBACK(2,\"被退回\")'")
/*     */   private PromotionActivityConsumptionStatus status;
/*     */   @Column(columnDefinition="varchar(255) comment '描述'")
/*     */   private String description;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '优惠金额'")
/*     */   private BigDecimal discount;
/*     */   
/*     */   public Long getOrderNum()
/*     */   {
/*  43 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(Long orderNum) {
/*  47 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public BigDecimal getDiscount() {
/*  51 */     return this.discount;
/*     */   }
/*     */   
/*     */   public void setDiscount(BigDecimal discount) {
/*  55 */     this.discount = discount;
/*     */   }
/*     */   
/*     */   public Long getCustomerId() {
/*  59 */     return this.customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(Long customerId) {
/*  63 */     this.customerId = customerId;
/*     */   }
/*     */   
/*     */   public Long getOrderId() {
/*  67 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(Long orderId) {
/*  71 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  75 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  79 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getPromotionActivityId() {
/*  83 */     return this.promotionActivityId;
/*     */   }
/*     */   
/*     */   public void setPromotionActivityId(Long promotionActivityId) {
/*  87 */     this.promotionActivityId = promotionActivityId;
/*     */   }
/*     */   
/*     */   public PromotionActivityConsumptionStatus getStatus() {
/*  91 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(PromotionActivityConsumptionStatus status) {
/*  95 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  99 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 103 */     this.description = description;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\PromotionActivityConsumption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */