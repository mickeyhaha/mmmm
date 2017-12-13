/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.UserStatus;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ @Entity
/*    */ @javax.persistence.Table(name="t_user")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class User extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="varchar(30) comment '用户名'", unique=true)
/*    */   private String username;
/*    */   @Column(columnDefinition="varchar(100) comment '密码'")
/*    */   private String password;
/*    */   @Column(columnDefinition="varchar(12) comment '手机号码'", unique=true)
/*    */   private String mobile;
/*    */   @Column(columnDefinition="varchar(12) comment '状态 ENABLE(\"启用\"), DISABLE(\"禁用\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private UserStatus status;
/*    */   @Column(columnDefinition="bigint comment '每个用户加密码 加密盐'")
/*    */   private Long salt;
/*    */   @Column(columnDefinition="varchar(50) comment '访问accessToken 生成规则 id + username + timestamp'", unique=true)
/*    */   private String accessToken;
/*    */   
/*    */   public String getAccessToken()
/*    */   {
/* 36 */     return this.accessToken;
/*    */   }
/*    */   
/*    */   public void setAccessToken(String accessToken) {
/* 40 */     this.accessToken = accessToken;
/*    */   }
/*    */   
/*    */   public UserStatus getStatus() {
/* 44 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(UserStatus status) {
/* 48 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 52 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 56 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 60 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 64 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getMobile() {
/* 68 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 72 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public Long getSalt() {
/* 76 */     return this.salt;
/*    */   }
/*    */   
/*    */   public void setSalt(Long salt) {
/* 80 */     this.salt = salt;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */