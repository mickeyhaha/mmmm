/*    */ package com.antbox.domain.promotion;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import java.math.BigDecimal;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_promotion_activity_full_reduction")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class FullReduction
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint not null comment '活动id'")
/*    */   private Long promotionActivityId;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第一阶梯价格'")
/*    */   private BigDecimal firstPrice;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第一阶梯折扣'")
/*    */   private BigDecimal firstDiscount;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第二阶梯价格'")
/*    */   private BigDecimal secondPrice;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第二阶梯折扣'")
/*    */   private BigDecimal secondDiscount;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第三阶梯价格'")
/*    */   private BigDecimal thirdPrice;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '第三阶梯折扣'")
/*    */   private BigDecimal thirdDiscount;
/*    */   
/*    */   public Long getPromotionActivityId()
/*    */   {
/* 40 */     return this.promotionActivityId;
/*    */   }
/*    */   
/*    */   public void setPromotionActivityId(Long promotionActivityId) {
/* 44 */     this.promotionActivityId = promotionActivityId;
/*    */   }
/*    */   
/*    */   public BigDecimal getFirstPrice() {
/* 48 */     return this.firstPrice;
/*    */   }
/*    */   
/*    */   public void setFirstPrice(BigDecimal firstPrice) {
/* 52 */     this.firstPrice = firstPrice;
/*    */   }
/*    */   
/*    */   public BigDecimal getFirstDiscount() {
/* 56 */     return this.firstDiscount;
/*    */   }
/*    */   
/*    */   public void setFirstDiscount(BigDecimal firstDiscount) {
/* 60 */     this.firstDiscount = firstDiscount;
/*    */   }
/*    */   
/*    */   public BigDecimal getSecondPrice() {
/* 64 */     return this.secondPrice;
/*    */   }
/*    */   
/*    */   public void setSecondPrice(BigDecimal secondPrice) {
/* 68 */     this.secondPrice = secondPrice;
/*    */   }
/*    */   
/*    */   public BigDecimal getSecondDiscount() {
/* 72 */     return this.secondDiscount;
/*    */   }
/*    */   
/*    */   public void setSecondDiscount(BigDecimal secondDiscount) {
/* 76 */     this.secondDiscount = secondDiscount;
/*    */   }
/*    */   
/*    */   public BigDecimal getThirdPrice() {
/* 80 */     return this.thirdPrice;
/*    */   }
/*    */   
/*    */   public void setThirdPrice(BigDecimal thirdPrice) {
/* 84 */     this.thirdPrice = thirdPrice;
/*    */   }
/*    */   
/*    */   public BigDecimal getThirdDiscount() {
/* 88 */     return this.thirdDiscount;
/*    */   }
/*    */   
/*    */   public void setThirdDiscount(BigDecimal thirdDiscount) {
/* 92 */     this.thirdDiscount = thirdDiscount;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\FullReduction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */