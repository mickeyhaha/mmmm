/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import javax.persistence.Column;
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
/*    */ public class CustomStringIDEntity
/*    */   extends BaseEntity
/*    */ {
/*    */   @Id
/*    */   @Column(name="id", length=50, unique=true, nullable=false, insertable=false, updatable=false)
/*    */   protected String id;
/*    */   
/*    */   public CustomStringIDEntity(String id)
/*    */   {
/* 29 */     this.id = id;
/*    */   }
/*    */   
/*    */   public CustomStringIDEntity() {}
/*    */   
/*    */   public String getId()
/*    */   {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 40 */     this.id = id;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CustomStringIDEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */