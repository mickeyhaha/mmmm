/*    */ package com.antbox.domain;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_merchant_user_box_role", indexes={@javax.persistence.Index(name="user_id_index", columnList="userId"), @javax.persistence.Index(name="box_id_index", columnList="boxId")})
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class MerchantUserBoxRole
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint COMMENT '运营商员工ID' NOT NULL")
/*    */   public Long userId;
/*    */   @Column(columnDefinition="bigint COMMENT '售货机 ID' NOT NULL")
/*    */   public Long boxId;
/*    */   
/*    */   public Long getUserId()
/*    */   {
/* 35 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 39 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 43 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 47 */     this.boxId = boxId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MerchantUserBoxRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */