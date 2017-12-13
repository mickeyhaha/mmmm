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
/*    */ @Table(name="t_rfid_machine")
/*    */ @Entity
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class RfidMachine
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="varchar(30) comment '版本号'")
/*    */   private String edition;
/*    */   @Column(columnDefinition="varchar(100) comment 'jar包名字'")
/*    */   private String name;
/*    */   @Column(columnDefinition="text comment '新依赖jar'")
/*    */   private String newDependJar;
/*    */   @Column(columnDefinition="text comment '旧依赖jar'")
/*    */   private String oldDependJar;
/*    */   
/*    */   public String getEdition()
/*    */   {
/* 36 */     return this.edition;
/*    */   }
/*    */   
/*    */   public void setEdition(String edition) {
/* 40 */     this.edition = edition;
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
/*    */   public String getNewDependJar() {
/* 52 */     return this.newDependJar;
/*    */   }
/*    */   
/*    */   public void setNewDependJar(String newDependJar) {
/* 56 */     this.newDependJar = newDependJar;
/*    */   }
/*    */   
/*    */   public String getOldDependJar() {
/* 60 */     return this.oldDependJar;
/*    */   }
/*    */   
/*    */   public void setOldDependJar(String oldDependJar) {
/* 64 */     this.oldDependJar = oldDependJar;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\RfidMachine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */