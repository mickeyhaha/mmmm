/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.SystemType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ @Entity
/*    */ @javax.persistence.Table(name="t_user_role")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class UserRole extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment'用户id'", nullable=false)
/*    */   private Long userId;
/*    */   @Column(columnDefinition="bigint comment'角色id'", nullable=false)
/*    */   private Long roleId;
/*    */   @Column(columnDefinition="varchar(50) comment '系统类型 OPERATION(\"运营端\"), MALL(\"平台端\"), MERCHANT(\"商户端\")'")
/*    */   @javax.persistence.Enumerated(EnumType.STRING)
/*    */   private SystemType systemType;
/*    */   @Column(columnDefinition="bigint comment '关联系统id 类型为MALL,relationSystemId = mallId、类型为OPERATION,relationSystemId= 0L、类型为MERCHANT,relationSystemId = merchantId'")
/*    */   private Long relationSystemId;
/*    */   
/*    */   public Long getUserId()
/*    */   {
/* 31 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 35 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Long getRoleId() {
/* 39 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(Long roleId) {
/* 43 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public SystemType getSystemType() {
/* 47 */     return this.systemType;
/*    */   }
/*    */   
/*    */   public void setSystemType(SystemType systemType) {
/* 51 */     this.systemType = systemType;
/*    */   }
/*    */   
/*    */   public Long getRelationSystemId() {
/* 55 */     return this.relationSystemId;
/*    */   }
/*    */   
/*    */   public void setRelationSystemId(Long relationSystemId) {
/* 59 */     this.relationSystemId = relationSystemId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\UserRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */