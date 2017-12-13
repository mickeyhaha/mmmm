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
/*    */ @Table(name="t_rfid_product")
/*    */ @Entity
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class RfidProduct
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '加盟商ID'")
/*    */   private Long merchantId;
/*    */   @Column(columnDefinition="bigint comment '产品ID'", nullable=false)
/*    */   private Long productId;
/*    */   @Column(columnDefinition="varchar(80) comment '产品名称'")
/*    */   private String productName;
/*    */   @Column(columnDefinition="varchar(100) comment '一体机标签'", unique=true, nullable=false)
/*    */   private String rfid;
/*    */   @Column(columnDefinition="varchar(30) comment '产品批次号'")
/*    */   private String productLotno;
/*    */   
/*    */   public Long getProductId()
/*    */   {
/* 37 */     return this.productId;
/*    */   }
/*    */   
/*    */   public void setProductId(Long productId) {
/* 41 */     this.productId = productId;
/*    */   }
/*    */   
/*    */   public String getRfid() {
/* 45 */     return this.rfid;
/*    */   }
/*    */   
/*    */   public void setRfid(String rfid) {
/* 49 */     this.rfid = rfid;
/*    */   }
/*    */   
/*    */   public String getProductName() {
/* 53 */     return this.productName;
/*    */   }
/*    */   
/*    */   public void setProductName(String productName) {
/* 57 */     this.productName = productName;
/*    */   }
/*    */   
/*    */   public Long getMerchantId() {
/* 61 */     return this.merchantId;
/*    */   }
/*    */   
/*    */   public void setMerchantId(Long merchantId) {
/* 65 */     this.merchantId = merchantId;
/*    */   }
/*    */   
/*    */   public String getProductLotno() {
/* 69 */     return this.productLotno;
/*    */   }
/*    */   
/*    */   public void setProductLotno(String productLotno) {
/* 73 */     this.productLotno = productLotno;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\RfidProduct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */