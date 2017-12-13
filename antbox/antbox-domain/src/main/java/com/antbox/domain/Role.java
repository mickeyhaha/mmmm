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
/*    */ @Table(name="t_role")
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class Role
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="varchar(50) comment '角色名称'")
/*    */   private String name;
/*    */   @Column(columnDefinition="varchar(50) comment '系统类型 OPERATION(\"运营端\"), MALL(\"平台端\"), MERCHANT(\"商户端\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private SystemType systemType;
/*    */   @Column(columnDefinition="bigint comment '关联系统id 类型为MALL,relationSystemId = mallId、类型为OPERATION,relationSystemId= 0L、类型为MERCHANT,relationSystemId = merchantId'")
/*    */   private Long relationSystemId;
/*    */   public static final String CHECK_SYSTEM_TYPE_IS_NOT_NULL = "systemType 不能为空";
/*    */   public static final String CHECK_RELATION_ID_IS_NOT_NULL = "relationSystemId 不能为空";
/*    */   public static final String CHECK_NAME_IS_NOT_NULL = "name 不能为空";
/*    */   public static final String CLASS_TITLE = "角色 ";
/*    */   
/*    */   public String getName()
/*    */   {
/* 39 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 43 */     this.name = name;
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


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Role.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */