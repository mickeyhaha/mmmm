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
/*    */ @Entity
/*    */ @Table(name="t_customer_partner")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class CustomerPartner
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="BIGINT COMMENT '用户id'")
/*    */   private Long customerId;
/*    */   @Column(columnDefinition="varchar(15) comment '手机号码'", unique=true)
/*    */   private String mobile;
/*    */   @Column(columnDefinition="varchar(50) COMMENT '用户id'")
/*    */   private String partnerCustomerId;
/*    */   
/*    */   public Long getCustomerId()
/*    */   {
/* 32 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 36 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public String getMobile() {
/* 40 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 44 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public String getPartnerCustomerId() {
/* 48 */     return this.partnerCustomerId;
/*    */   }
/*    */   
/*    */   public void setPartnerCustomerId(String partnerCustomerId) {
/* 52 */     this.partnerCustomerId = partnerCustomerId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\CustomerPartner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */