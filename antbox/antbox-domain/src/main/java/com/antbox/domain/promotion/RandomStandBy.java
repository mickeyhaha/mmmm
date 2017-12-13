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
/*    */ @Table(name="t_promotion_activity_random_stand_by")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class RandomStandBy
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint not null comment '活动id'")
/*    */   private Long promotionActivityId;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '最大优惠金额'")
/*    */   private BigDecimal maxDiscount;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '最小优惠金额'")
/*    */   private BigDecimal minDiscount;
/*    */   
/*    */   public Long getPromotionActivityId()
/*    */   {
/* 32 */     return this.promotionActivityId;
/*    */   }
/*    */   
/*    */   public void setPromotionActivityId(Long promotionActivityId) {
/* 36 */     this.promotionActivityId = promotionActivityId;
/*    */   }
/*    */   
/*    */   public BigDecimal getMaxDiscount() {
/* 40 */     return this.maxDiscount;
/*    */   }
/*    */   
/*    */   public void setMaxDiscount(BigDecimal maxDiscount) {
/* 44 */     this.maxDiscount = maxDiscount;
/*    */   }
/*    */   
/*    */   public BigDecimal getMinDiscount() {
/* 48 */     return this.minDiscount;
/*    */   }
/*    */   
/*    */   public void setMinDiscount(BigDecimal minDiscount) {
/* 52 */     this.minDiscount = minDiscount;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\RandomStandBy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */