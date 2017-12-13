/*    */ package com.antbox.domain.promotion;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_promotion_activity_box", indexes={@javax.persistence.Index(name="promotion_activity_id", columnList="promotionActivityId"), @javax.persistence.Index(name="box_id_index", columnList="boxId")})
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class PromotionActivityBox
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint not null comment 'BOX ID'")
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="bigint not null comment '促销活动ID'")
/*    */   private Long promotionActivityId;
/*    */   
/*    */   public Long getBoxId()
/*    */   {
/* 32 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 36 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public Long getPromotionActivityId() {
/* 40 */     return this.promotionActivityId;
/*    */   }
/*    */   
/*    */   public void setPromotionActivityId(Long promotionActivityId) {
/* 44 */     this.promotionActivityId = promotionActivityId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\PromotionActivityBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */