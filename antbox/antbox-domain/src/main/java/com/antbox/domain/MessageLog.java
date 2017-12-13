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
/*    */ @Entity
/*    */ @Table(name="t_message_log")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class MessageLog
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="BIGINT COMMENT '平台ID'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="BIGINT COMMENT '加盟商ID'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="VARCHAR(11) COMMENT '手机号'")
/*    */   private String mobile;
/*    */   @Column(columnDefinition="VARCHAR(1000) COMMENT '短信内容'")
/*    */   private String content;
/*    */   @Column(columnDefinition="VARCHAR(50) COMMENT '短信状态'")
/*    */   private String status;
/*    */   
/*    */   public Long getMallId()
/*    */   {
/* 34 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 38 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 42 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 46 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public String getMobile() {
/* 50 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 54 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 58 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 62 */     this.content = content;
/*    */   }
/*    */   
/*    */   public String getStatus() {
/* 66 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 70 */     this.status = status;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\MessageLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */