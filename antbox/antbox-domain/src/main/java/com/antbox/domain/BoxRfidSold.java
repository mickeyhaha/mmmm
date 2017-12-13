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
/*    */ @Table(name="t_box_rfid_sold", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"boxId", "rfid"})})
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class BoxRfidSold
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '售货机id'")
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="bigint comment '产品id'")
/*    */   private Long productId;
/*    */   @Column(columnDefinition="varchar(255) comment '产品名称'")
/*    */   private String productName;
/*    */   @Column(columnDefinition="varchar(50) comment 'rfid'")
/*    */   private String rfid;
/*    */   
/*    */   public Long getBoxId()
/*    */   {
/* 35 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 39 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public Long getProductId() {
/* 43 */     return this.productId;
/*    */   }
/*    */   
/*    */   public void setProductId(Long productId) {
/* 47 */     this.productId = productId;
/*    */   }
/*    */   
/*    */   public String getProductName() {
/* 51 */     return this.productName;
/*    */   }
/*    */   
/*    */   public void setProductName(String productName) {
/* 55 */     this.productName = productName;
/*    */   }
/*    */   
/*    */   public String getRfid() {
/* 59 */     return this.rfid;
/*    */   }
/*    */   
/*    */   public void setRfid(String rfid) {
/* 63 */     this.rfid = rfid;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxRfidSold.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */