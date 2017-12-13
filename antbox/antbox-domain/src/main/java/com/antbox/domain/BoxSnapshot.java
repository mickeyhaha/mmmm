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
/*    */ @Table(name="t_box_snapshot")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class BoxSnapshot
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '售货机id'", unique=true)
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="varchar(255) comment '当前购买客户'")
/*    */   private String currentCustomer;
/*    */   @Column(columnDefinition="varchar(255) comment '最后盘点客户'")
/*    */   private String lastInventoryCustomer;
/*    */   @Column(columnDefinition="varchar(5000) comment '最后一次盘点rfid标签数组'")
/*    */   private String lastInventoryRfid;
/*    */   
/*    */   public String getLastInventoryRfid()
/*    */   {
/* 35 */     return this.lastInventoryRfid;
/*    */   }
/*    */   
/*    */   public void setLastInventoryRfid(String lastInventoryRfid) {
/* 39 */     this.lastInventoryRfid = lastInventoryRfid;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 43 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 47 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public String getCurrentCustomer() {
/* 51 */     return this.currentCustomer;
/*    */   }
/*    */   
/*    */   public void setCurrentCustomer(String currentCustomer) {
/* 55 */     this.currentCustomer = currentCustomer;
/*    */   }
/*    */   
/*    */   public String getLastInventoryCustomer() {
/* 59 */     return this.lastInventoryCustomer;
/*    */   }
/*    */   
/*    */   public void setLastInventoryCustomer(String lastInventoryCustomer) {
/* 63 */     this.lastInventoryCustomer = lastInventoryCustomer;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxSnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */