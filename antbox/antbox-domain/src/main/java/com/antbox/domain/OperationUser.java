/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.common.Whether;
/*    */ import com.antbox.domain.enumclass.UserStatus;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_operation_user")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class OperationUser
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '用户 id'", unique=true)
/*    */   private Long userId;
/*    */   @Column(columnDefinition="varchar(100) comment '用户名称'")
/*    */   private String name;
/*    */   @Column(columnDefinition="varchar(20) comment '是否超级管理员  YES(\"是\"), NO(\"否\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private Whether isAdmin;
/*    */   @Column(columnDefinition="varchar(12) comment '状态 ENABLE(\"启用\"), DISABLE(\"禁用\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private UserStatus status;
/*    */   
/*    */   public UserStatus getStatus()
/*    */   {
/* 37 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(UserStatus status) {
/* 41 */     this.status = status;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 45 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 49 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 53 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 57 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Whether getIsAdmin() {
/* 61 */     return this.isAdmin;
/*    */   }
/*    */   
/*    */   public void setIsAdmin(Whether isAdmin) {
/* 65 */     this.isAdmin = isAdmin;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\OperationUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */