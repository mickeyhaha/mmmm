/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.CustomLongIDEntity;
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
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_area")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class Area
/*    */   extends CustomLongIDEntity
/*    */ {
/*    */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'", nullable=false)
/*    */   private String area;
/*    */   @Column(columnDefinition="INT COMMENT '区ID'", nullable=false)
/*    */   private Integer areaID;
/*    */   @Column(columnDefinition="INT COMMENT '父ID'", nullable=false)
/*    */   private Integer fatherID;
/*    */   
/*    */   public Integer getAreaID()
/*    */   {
/* 37 */     return this.areaID;
/*    */   }
/*    */   
/*    */   public void setAreaID(Integer areaID) {
/* 41 */     this.areaID = areaID;
/*    */   }
/*    */   
/*    */   public Integer getFatherID() {
/* 45 */     return this.fatherID;
/*    */   }
/*    */   
/*    */   public void setFatherID(Integer fatherID) {
/* 49 */     this.fatherID = fatherID;
/*    */   }
/*    */   
/*    */   public String getArea() {
/* 53 */     return this.area;
/*    */   }
/*    */   
/*    */   public void setArea(String area) {
/* 57 */     this.area = area;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Area.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */