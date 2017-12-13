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
/*    */ @Entity
/*    */ @Table(name="t_open_push_distribution_Order")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class OpenPushDistributionOrder
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '商家id'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="int comment '推送次数'")
/*    */   private Integer pushNum;
/*    */   @Column(columnDefinition="varchar(30) comment '配货单号'")
/*    */   private String orderNum;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 35 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 39 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 43 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 47 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Integer getPushNum() {
/* 51 */     return this.pushNum;
/*    */   }
/*    */   
/*    */   public void setPushNum(Integer pushNum) {
/* 55 */     this.pushNum = pushNum;
/*    */   }
/*    */   
/*    */   public String getOrderNum() {
/* 59 */     return this.orderNum;
/*    */   }
/*    */   
/*    */   public void setOrderNum(String orderNum) {
/* 63 */     this.orderNum = orderNum;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OpenPushDistributionOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */