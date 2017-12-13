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
/*    */ @Entity
/*    */ @Table(name="t_box_config")
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class BoxConfig
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '售货机id'", unique=true)
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="bigint comment '盘点次数'")
/*    */   private Long inventoryTimes;
/*    */   
/*    */   public Long getInventoryTimes()
/*    */   {
/* 29 */     return this.inventoryTimes;
/*    */   }
/*    */   
/*    */   public void setInventoryTimes(Long inventoryTimes) {
/* 33 */     this.inventoryTimes = inventoryTimes;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 37 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 41 */     this.boxId = boxId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */