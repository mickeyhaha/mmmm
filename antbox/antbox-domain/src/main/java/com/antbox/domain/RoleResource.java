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
/*    */ @Entity
/*    */ @Table(name="t_role_resource")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class RoleResource
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '角色id'", nullable=false)
/*    */   private Long roleId;
/*    */   @Column(columnDefinition="bigint comment '资源id'", nullable=false)
/*    */   private Long resourceId;
/*    */   @Column(columnDefinition="bigint comment '资源父id'")
/*    */   private Long resourceParentId;
/*    */   
/*    */   public Long getRoleId()
/*    */   {
/* 29 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(Long roleId) {
/* 33 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public Long getResourceId() {
/* 37 */     return this.resourceId;
/*    */   }
/*    */   
/*    */   public void setResourceId(Long resourceId) {
/* 41 */     this.resourceId = resourceId;
/*    */   }
/*    */   
/*    */   public Long getResourceParentId() {
/* 45 */     return this.resourceParentId;
/*    */   }
/*    */   
/*    */   public void setResourceParentId(Long resourceParentId) {
/* 49 */     this.resourceParentId = resourceParentId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\RoleResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */