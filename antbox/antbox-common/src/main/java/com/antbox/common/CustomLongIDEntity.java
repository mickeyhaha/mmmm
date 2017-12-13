/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ @JsonInclude(JsonInclude.Include.NON_NULL)
/*    */ @JsonIgnoreProperties({"updatedAt", "deleted", "version", "createdAt"})
/*    */ public class CustomLongIDEntity
/*    */   extends BaseEntity
/*    */ {
/*    */   @Id
/*    */   protected Long id;
/*    */   
/*    */   public CustomLongIDEntity(Long id)
/*    */   {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   public CustomLongIDEntity() {}
/*    */   
/*    */   public Long getId()
/*    */   {
/* 34 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 38 */     this.id = id;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CustomLongIDEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */