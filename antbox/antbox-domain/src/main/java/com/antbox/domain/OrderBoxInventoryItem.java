/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_order_box_inventory_item")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class OrderBoxInventoryItem
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="bigint comment 'orderBoxInventoryId'")
/*     */   private Long orderBoxInventoryId;
/*     */   @Column(columnDefinition="bigint not null comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="bigint comment '产品 id'")
/*     */   private Long productId;
/*     */   @Column(columnDefinition="varchar(100) comment '产品 名称'")
/*     */   private String productName;
/*     */   @Column(columnDefinition="smallint not null comment '购买数量'")
/*     */   private Integer amount;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '成本价'")
/*     */   private BigDecimal costPrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '销售价格'")
/*     */   private BigDecimal salePrice;
/*     */   @Column(columnDefinition="DECIMAL(19,2) COMMENT '总价格'")
/*     */   private BigDecimal totalPrice;
/*     */   
/*     */   public Long getOrderBoxInventoryId()
/*     */   {
/*  42 */     return this.orderBoxInventoryId;
/*     */   }
/*     */   
/*     */   public void setOrderBoxInventoryId(Long orderBoxInventoryId) {
/*  46 */     this.orderBoxInventoryId = orderBoxInventoryId;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/*  50 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/*  54 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public Long getProductId() {
/*  58 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  62 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  66 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/*  70 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public Integer getAmount() {
/*  74 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Integer amount) {
/*  78 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public BigDecimal getCostPrice() {
/*  82 */     return this.costPrice;
/*     */   }
/*     */   
/*     */   public void setCostPrice(BigDecimal costPrice) {
/*  86 */     this.costPrice = costPrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getSalePrice() {
/*  90 */     return this.salePrice;
/*     */   }
/*     */   
/*     */   public void setSalePrice(BigDecimal salePrice) {
/*  94 */     this.salePrice = salePrice;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPrice() {
/*  98 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(BigDecimal totalPrice) {
/* 102 */     this.totalPrice = totalPrice;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OrderBoxInventoryItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */