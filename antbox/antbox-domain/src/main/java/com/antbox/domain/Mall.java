/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.MallStatus;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_mall")
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class Mall
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="varchar(12) comment '状态 ENABLE(\"启用\"), DISABLE(\"禁用\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private MallStatus status;
/*    */   @Column(columnDefinition="varchar(50) comment '商家名称'")
/*    */   private String name;
/*    */   @Column(columnDefinition="varchar(50) comment '公司名称'")
/*    */   private String companyName;
/*    */   @Column(columnDefinition="varchar(255) comment '地址'")
/*    */   private String address;
/*    */   @Column(columnDefinition="varchar(50) comment '平台域名'", unique=true)
/*    */   private String domain;
/*    */   
/*    */   public MallStatus getStatus()
/*    */   {
/* 36 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(MallStatus status) {
/* 40 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 44 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 48 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getAddress() {
/* 52 */     return this.address;
/*    */   }
/*    */   
/*    */   public void setAddress(String address) {
/* 56 */     this.address = address;
/*    */   }
/*    */   
/*    */   public String getCompanyName() {
/* 60 */     return this.companyName;
/*    */   }
/*    */   
/*    */   public void setCompanyName(String companyName) {
/* 64 */     this.companyName = companyName;
/*    */   }
/*    */   
/*    */   public String getDomain() {
/* 68 */     return this.domain;
/*    */   }
/*    */   
/*    */   public void setDomain(String domain) {
/* 72 */     this.domain = domain;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Mall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */