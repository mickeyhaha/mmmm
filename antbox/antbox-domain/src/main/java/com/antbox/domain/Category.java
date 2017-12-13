/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.SystemType;
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
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_category")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class Category
/*    */   extends IDEntity
/*    */ {
/*    */   public static final String CHECK_NAME_IS_NOT_NULL = "名称不能为空";
/*    */   public static final String CHECK_MALL_ID_IS_NOT_NULL = "平台ID不能为空";
/*    */   public static final String CHECK_SYSTEM_TYPE_IS_NOT_NULL = "系统类型不能为空";
/*    */   public static final String CHECK_PARENT_ID_IS_NOT_NULL = "父类目ID不能为空";
/*    */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'")
/*    */   private String name;
/*    */   @Column(columnDefinition="BIGINT COMMENT '父类目ID'")
/*    */   private Long parentId;
/*    */   @Column(columnDefinition="BIGINT COMMENT '平台ID'")
/*    */   private Long mallId;
/*    */   @Column(columnDefinition="VARCHAR(50) COMMENT '系统类型 OPERATOR(运营端), MALL(平台端), MERCHANT(商户端)'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private SystemType systemType;
/*    */   @Column(columnDefinition="BIGINT DEFAULT 0 COMMENT '同级排序号 升序'")
/*    */   private Long sort;
/*    */   
/*    */   public String getName()
/*    */   {
/* 43 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 47 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Long getParentId() {
/* 51 */     return this.parentId;
/*    */   }
/*    */   
/*    */   public void setParentId(Long parentId) {
/* 55 */     this.parentId = parentId;
/*    */   }
/*    */   
/*    */   public Long getMallId() {
/* 59 */     return this.mallId;
/*    */   }
/*    */   
/*    */   public void setMallId(Long mallId) {
/* 63 */     this.mallId = mallId;
/*    */   }
/*    */   
/*    */   public SystemType getSystemType() {
/* 67 */     return this.systemType;
/*    */   }
/*    */   
/*    */   public void setSystemType(SystemType systemType) {
/* 71 */     this.systemType = systemType;
/*    */   }
/*    */   
/*    */   public Long getSort() {
/* 75 */     return this.sort;
/*    */   }
/*    */   
/*    */   public void setSort(Long sort) {
/* 79 */     this.sort = sort;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Category.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */