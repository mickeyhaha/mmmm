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
/*    */ @Table(name="t_promotion_activity_first_single")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class FirstSingle
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint not null comment '活动id'")
/*    */   private Long promotionActivityId;
/*    */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '优惠金额'")
/*    */   private BigDecimal discount;
/*    */   
/*    */   public BigDecimal getDiscount()
/*    */   {
/* 30 */     return this.discount;
/*    */   }
/*    */   
/*    */   public void setDiscount(BigDecimal discount) {
/* 34 */     this.discount = discount;
/*    */   }
/*    */   
/*    */   public Long getPromotionActivityId() {
/* 38 */     return this.promotionActivityId;
/*    */   }
/*    */   
/*    */   public void setPromotionActivityId(Long promotionActivityId) {
/* 42 */     this.promotionActivityId = promotionActivityId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\FirstSingle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */