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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_province")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class Province
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'", nullable=false)
/*    */   private String province;
/*    */   @Column(columnDefinition="INT COMMENT '省份ID'", nullable=false)
/*    */   private Integer provinceID;
/*    */   
/*    */   public Integer getProvinceID()
/*    */   {
/* 33 */     return this.provinceID;
/*    */   }
/*    */   
/*    */   public void setProvinceID(Integer provinceID) {
/* 37 */     this.provinceID = provinceID;
/*    */   }
/*    */   
/*    */   public String getProvince() {
/* 41 */     return this.province;
/*    */   }
/*    */   
/*    */   public void setProvince(String province) {
/* 45 */     this.province = province;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Province.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */