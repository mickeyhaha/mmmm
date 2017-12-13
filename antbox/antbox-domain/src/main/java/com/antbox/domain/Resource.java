/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.ResourceType;
/*     */ import com.antbox.domain.enumclass.SystemType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ @javax.persistence.Table(name="t_resource")
/*     */ @Entity
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Resource extends IDEntity
/*     */ {
/*     */   public static final String CHECK_PARENT_ID_IS_NOT_NULL = "parentId 不能为空";
/*     */   public static final String CHECK_NAME_IS_NOT_NULL = "name 不能为空";
/*     */   public static final String CHECK_TYPE_IS_NOT_NULL = "type 不能为空";
/*     */   public static final String CHECK_SYSTEM_TYPE_IS_NOT_NULL = "systemType 不能为空";
/*     */   @Column(columnDefinition="varchar(50) comment '名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="varchar(255) comment '前端url'")
/*     */   private String frontendUrl;
/*     */   @Column(columnDefinition="text comment '后端url 是一个数组结构'")
/*     */   private String backendUrl;
/*     */   @Column(columnDefinition="bigint comment '父级id'")
/*     */   private Long parentId;
/*     */   @Column(columnDefinition="bigint default 0 comment '同级排序号 升序'", nullable=false)
/*     */   private Long sort;
/*     */   @Column(columnDefinition="varchar(50) comment '类型 MENU(\"菜单\"), BUTTON(\"按钮\")'", nullable=false)
/*     */   @Enumerated(EnumType.STRING)
/*     */   private ResourceType type;
/*     */   @Column(columnDefinition="varchar(50) comment '系统类型 OPERATION(\"运营中心\"), MALL(\"平台商\"), MERCHANT(\"加盟商\")'", nullable=false)
/*     */   @Enumerated(EnumType.STRING)
/*     */   private SystemType systemType;
/*     */   @Column(columnDefinition="varchar(50) comment '图标'")
/*     */   private String icon;
/*     */   
/*     */   public String getIcon()
/*     */   {
/*  46 */     return this.icon;
/*     */   }
/*     */   
/*     */   public void setIcon(String icon) {
/*  50 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public String getFrontendUrl() {
/*  54 */     return this.frontendUrl;
/*     */   }
/*     */   
/*     */   public void setFrontendUrl(String frontendUrl) {
/*  58 */     this.frontendUrl = frontendUrl;
/*     */   }
/*     */   
/*     */   public String getBackendUrl() {
/*  62 */     return this.backendUrl;
/*     */   }
/*     */   
/*     */   public void setBackendUrl(String backendUrl) {
/*  66 */     this.backendUrl = backendUrl;
/*     */   }
/*     */   
/*     */   public Long getParentId() {
/*  70 */     return this.parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(Long parentId) {
/*  74 */     this.parentId = parentId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  78 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  82 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Long getSort() {
/*  86 */     return this.sort;
/*     */   }
/*     */   
/*     */   public void setSort(Long sort) {
/*  90 */     this.sort = sort;
/*     */   }
/*     */   
/*     */   public SystemType getSystemType() {
/*  94 */     return this.systemType;
/*     */   }
/*     */   
/*     */   public void setSystemType(SystemType systemType) {
/*  98 */     this.systemType = systemType;
/*     */   }
/*     */   
/*     */   public ResourceType getType() {
/* 102 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(ResourceType type) {
/* 106 */     this.type = type;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Resource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */