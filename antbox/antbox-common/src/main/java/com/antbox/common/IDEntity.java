/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ @JsonInclude(JsonInclude.Include.NON_NULL)
/*    */ @JsonIgnoreProperties(value={"updatedAt", "deleted", "version", "createdAt"}, ignoreUnknown=true)
/*    */ public class IDEntity
/*    */   extends BaseEntity
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   protected Long id;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 27 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 31 */     this.id = id;
/*    */   }
/*    */   
/*    */   public IDEntity(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public IDEntity() {}
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 42 */     if (this == o) return true;
/* 43 */     if ((o == null) || (getClass() != o.getClass())) { return false;
/*    */     }
/* 45 */     IDEntity idEntity = (IDEntity)o;
/*    */     
/* 47 */     return this.id.equals(idEntity.id);
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 52 */     return this.id.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\IDEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */