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
/*    */ @Table(name="t_rfid_rssi")
/*    */ @Entity
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class RfitRssi
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment 'RSSI最低标准值'")
/*    */   private Long rssiValue;
/*    */   
/*    */   public Long getRssiValue()
/*    */   {
/* 26 */     return this.rssiValue;
/*    */   }
/*    */   
/*    */   public void setRssiValue(Long rssiValue) {
/* 30 */     this.rssiValue = rssiValue;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\RfitRssi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */