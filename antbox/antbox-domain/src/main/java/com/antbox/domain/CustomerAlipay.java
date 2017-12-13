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
/*    */ @Entity
/*    */ @Table(name="t_customer_alipay")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class CustomerAlipay
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '客户id'")
/*    */   private Long customerId;
/*    */   @Column(columnDefinition="varchar(20) comment '手机号码'")
/*    */   private String mobile;
/*    */   @Column(columnDefinition="varchar(50) comment '支付宝用户 id'")
/*    */   private String alipayUserId;
/*    */   @Column(columnDefinition="varchar(50) comment '支付宝用户 昵称'")
/*    */   private String alipayNickname;
/*    */   
/*    */   public String getMobile()
/*    */   {
/* 38 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 42 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public Long getCustomerId() {
/* 46 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 50 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public String getAlipayUserId() {
/* 54 */     return this.alipayUserId;
/*    */   }
/*    */   
/*    */   public void setAlipayUserId(String alipayUserId) {
/* 58 */     this.alipayUserId = alipayUserId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getAlipayNickname()
/*    */   {
/* 68 */     return this.alipayNickname;
/*    */   }
/*    */   
/*    */   public void setAlipayNickname(String alipayNickname) {
/* 72 */     this.alipayNickname = alipayNickname;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\CustomerAlipay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */