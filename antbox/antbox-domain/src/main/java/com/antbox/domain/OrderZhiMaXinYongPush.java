/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.OrderStatus;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_order_zhimaxinyong_push", indexes={@javax.persistence.Index(name="orderIdIndex", columnList="orderId"), @javax.persistence.Index(name="pushTimeIndex", columnList="pushTime")})
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ public class OrderZhiMaXinYongPush
/*    */   extends IDEntity
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @Column(columnDefinition="bigint COMMENT 'order id' NOT NULL DEFAULT 0", nullable=false, unique=true)
/*    */   private Long orderId;
/*    */   @Column(columnDefinition="INT(2) COMMENT '状态 WAIT(0,\"待支付\"), SUCCESS(1,\"支付成功\"), FAIL(2,\"支付失败\")'", nullable=false)
/*    */   private OrderStatus status;
/*    */   @Column(columnDefinition="INT(2) DEFAULT -1 COMMENT '状态 WAIT(0,\"待支付\"), SUCCESS(1,\"支付成功\"), FAIL(2,\"支付失败\")'", nullable=false)
/*    */   private OrderStatus lastStatus;
/*    */   @Column(columnDefinition="INT NOT NULL DEFAULT 1", nullable=false)
/*    */   private Integer pushCount;
/*    */   @Column(nullable=false)
/*    */   private Long pushTime;
/*    */   
/*    */   public OrderZhiMaXinYongPush() {}
/*    */   
/*    */   public OrderZhiMaXinYongPush(Long orderId, OrderStatus status, long pushTime)
/*    */   {
/* 48 */     this.orderId = orderId;
/* 49 */     this.status = status;
/* 50 */     this.pushTime = Long.valueOf(pushTime);
/*    */   }
/*    */   
/*    */   public Long getOrderId() {
/* 54 */     return this.orderId;
/*    */   }
/*    */   
/*    */   public void setOrderId(Long orderId) {
/* 58 */     this.orderId = orderId;
/*    */   }
/*    */   
/*    */   public OrderStatus getStatus() {
/* 62 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(OrderStatus status) {
/* 66 */     this.status = status;
/*    */   }
/*    */   
/*    */   public Long getPushTime() {
/* 70 */     return this.pushTime;
/*    */   }
/*    */   
/*    */   public void setPushTime(Long pushTime) {
/* 74 */     this.pushTime = pushTime;
/*    */   }
/*    */   
/*    */   public OrderStatus getLastStatus() {
/* 78 */     return this.lastStatus;
/*    */   }
/*    */   
/*    */   public void setLastStatus(OrderStatus lastStatus) {
/* 82 */     this.lastStatus = lastStatus;
/*    */   }
/*    */   
/*    */   public Integer getPushCount() {
/* 86 */     return this.pushCount;
/*    */   }
/*    */   
/*    */   public void setPushCount(Integer pushCount) {
/* 90 */     this.pushCount = pushCount;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderZhiMaXinYongPush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */