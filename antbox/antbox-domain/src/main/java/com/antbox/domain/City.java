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
/*    */ @Table(name="t_city")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class City
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'", nullable=false)
/*    */   private String city;
/*    */   @Column(columnDefinition="INT COMMENT '市ID'", nullable=false)
/*    */   private Integer cityID;
/*    */   @Column(columnDefinition="INT COMMENT '父ID'", nullable=false)
/*    */   private Integer fatherID;
/*    */   
/*    */   public Integer getCityID()
/*    */   {
/* 35 */     return this.cityID;
/*    */   }
/*    */   
/*    */   public void setCityID(Integer cityID) {
/* 39 */     this.cityID = cityID;
/*    */   }
/*    */   
/*    */   public Integer getFatherID() {
/* 43 */     return this.fatherID;
/*    */   }
/*    */   
/*    */   public void setFatherID(Integer fatherID) {
/* 47 */     this.fatherID = fatherID;
/*    */   }
/*    */   
/*    */   public String getCity() {
/* 51 */     return this.city;
/*    */   }
/*    */   
/*    */   public void setCity(String city) {
/* 55 */     this.city = city;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\City.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */