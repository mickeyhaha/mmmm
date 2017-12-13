/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.OrderPayLogType;
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
/*    */ @Table(name="t_order_pay_log")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class OrderPayLog
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '订单id'")
/*    */   private Long orderId;
/*    */   @Column(columnDefinition="varchar(50) comment '订单号'")
/*    */   private Long orderNum;
/*    */   @Column(columnDefinition="varchar(50) comment '日志标题'")
/*    */   private String title;
/*    */   @Column(columnDefinition="varchar(5000) comment '内容'")
/*    */   private String content;
/*    */   @Column(columnDefinition="smallint(2) comment '类型 WAIT(0, \"待支付\"), SUCCESS(1, \"支付成功\"), FAIL(2, \"支付失败\"), CALL_BACK_ORDER_NOT_EXIST(3, \"回调失败，订单不存在\"), CALL_BACK_SUCCEED_REPEAT(4, \"回调失败，订单已回调成功，支付宝重复回调了。\"), CALL_BACK_STATUS_EXCEPTION(5, \"回调失败，订单状态异常\"), CALL_BACK_ILLEGAL(6, \"恶意回调\")'")
/*    */   private OrderPayLogType type;
/*    */   @Column(columnDefinition="bigint comment '平台id'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="bigint comment '加盟商id'")
/*    */   private Long merchantId;
/*    */   
/*    */   public String getTypeText()
/*    */   {
/* 40 */     if (this.type != null) {
/* 41 */       return this.type.text;
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   public Long getMallId() {
/* 47 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 51 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 55 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 59 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 63 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 67 */     this.title = title;
/*    */   }
/*    */   
/*    */   public Long getOrderId() {
/* 71 */     return this.orderId;
/*    */   }
/*    */   
/*    */   public void setOrderId(Long orderId) {
/* 75 */     this.orderId = orderId;
/*    */   }
/*    */   
/*    */   public Long getOrderNum() {
/* 79 */     return this.orderNum;
/*    */   }
/*    */   
/*    */   public void setOrderNum(Long orderNum) {
/* 83 */     this.orderNum = orderNum;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 87 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 91 */     this.content = content;
/*    */   }
/*    */   
/*    */   public OrderPayLogType getType() {
/* 95 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(OrderPayLogType type) {
/* 99 */     this.type = type;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderPayLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */