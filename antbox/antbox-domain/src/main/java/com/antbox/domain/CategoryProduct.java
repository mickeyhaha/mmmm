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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_category_product")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class CategoryProduct
/*    */   extends IDEntity
/*    */ {
/*    */   public static final String CHECK_PRODUCT_ID_IS_NOT_NULL = "商品ID不能为空";
/*    */   public static final String CHECK_CATEGORY_ID_IS_NOT_NULL = "类目ID不能为空";
/*    */   @Column(columnDefinition="BIGINT NOT NULL COMMENT '商品ID'")
/*    */   private Long productId;
/*    */   @Column(columnDefinition="BIGINT NOT NULL COMMENT '类目ID'")
/*    */   private Long categoryId;
/*    */   
/*    */   public Long getProductId()
/*    */   {
/* 36 */     return this.productId;
/*    */   }
/*    */   
/*    */   public void setProductId(Long productId) {
/* 40 */     this.productId = productId;
/*    */   }
/*    */   
/*    */   public Long getCategoryId() {
/* 44 */     return this.categoryId;
/*    */   }
/*    */   
/*    */   public void setCategoryId(Long categoryId) {
/* 48 */     this.categoryId = categoryId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\CategoryProduct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */