/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
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
/*    */ @Table(name="t_open_push_order_status")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ public class OpenPushOrderStatus
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '商家id'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="int comment '推送次数'")
/*    */   private Integer pushNum;
/*    */   @Column(columnDefinition="VARCHAR(50) comment '订单号'")
/*    */   private Long orderNum;
/*    */   @Column(columnDefinition="VARCHAR(50) comment '第三方订单号'")
/*    */   private String partnerOrderNum;
/*    */   @Column(columnDefinition="VARCHAR(15) comment '订单状态'")
/*    */   private String status;
/*    */   @Column(columnDefinition="VARCHAR(15) comment '订单支付异常状态类型'")
/*    */   private String payExceptionType;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 42 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 46 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 50 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 54 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public Integer getPushNum() {
/* 58 */     return this.pushNum;
/*    */   }
/*    */   
/*    */   public void setPushNum(Integer pushNum) {
/* 62 */     this.pushNum = pushNum;
/*    */   }
/*    */   
/*    */   public Long getOrderNum() {
/* 66 */     return this.orderNum;
/*    */   }
/*    */   
/*    */   public void setOrderNum(Long orderNum) {
/* 70 */     this.orderNum = orderNum;
/*    */   }
/*    */   
/*    */   public String getPartnerOrderNum() {
/* 74 */     return this.partnerOrderNum;
/*    */   }
/*    */   
/*    */   public void setPartnerOrderNum(String partnerOrderNum) {
/* 78 */     this.partnerOrderNum = partnerOrderNum;
/*    */   }
/*    */   
/*    */   public String getStatus() {
/* 82 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 86 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getPayExceptionType() {
/* 90 */     return this.payExceptionType;
/*    */   }
/*    */   
/*    */   public void setPayExceptionType(String payExceptionType) {
/* 94 */     this.payExceptionType = payExceptionType;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 99 */     return "OpenPushOrderStatus{mallId=" + this.mallId + ", merchantId=" + this.merchantId + ", pushNum=" + this.pushNum + ", orderNum=" + this.orderNum + ", partnerOrderNum='" + this.partnerOrderNum + '\'' + ", status='" + this.status + '\'' + ", payExceptionType='" + this.payExceptionType + '\'' + '}';
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OpenPushOrderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */