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
/*    */ @JsonIgnoreProperties(value={"updatedAt", "deleted", "version", "createdAt"}, ignoreUnknown=true)
/*    */ public class CustomIDEntity
/*    */   extends BaseEntity
/*    */ {
/*    */   @Id
/*    */   protected Long id;
/*    */   
/*    */   public CustomIDEntity(Long id)
/*    */   {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   public CustomIDEntity() {}
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


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CustomIDEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */