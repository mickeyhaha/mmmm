/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import com.antbox.domain.enumclass.BoxStatus;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
/*    */ import org.hibernate.annotations.Where;
/*    */ 
/*    */ @Entity
/*    */ @javax.persistence.Table(name="t_box_router")
/*    */ @DynamicUpdate
/*    */ @DynamicInsert
/*    */ @Where(clause="deleted = 0")
/*    */ public class BoxRouter extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '售货机id'", unique=true)
/*    */   private Long boxId;
/*    */   @Column(columnDefinition="varchar(100) comment '对应server的真实地址'")
/*    */   private String location;
/*    */   @Column(columnDefinition="varchar(30) comment '售货机状态 ONLINE(\"在线\"), OFFLINE(\"离线\"), BREAKDOWN(\"故障\")'")
/*    */   @Enumerated(EnumType.STRING)
/*    */   private BoxStatus boxStatus;
/*    */   @Column(columnDefinition="bit default 1 comment '是否需要监控'")
/*    */   private Boolean isNeedMonitor;
/*    */   
/*    */   public String getLocation()
/*    */   {
/* 32 */     return this.location;
/*    */   }
/*    */   
/*    */   public void setLocation(String location) {
/* 36 */     this.location = location;
/*    */   }
/*    */   
/*    */   public BoxStatus getBoxStatus() {
/* 40 */     return this.boxStatus;
/*    */   }
/*    */   
/*    */   public void setBoxStatus(BoxStatus boxStatus) {
/* 44 */     this.boxStatus = boxStatus;
/*    */   }
/*    */   
/*    */   public Long getBoxId() {
/* 48 */     return this.boxId;
/*    */   }
/*    */   
/*    */   public void setBoxId(Long boxId) {
/* 52 */     this.boxId = boxId;
/*    */   }
/*    */   
/*    */   public Boolean getNeedMonitor() {
/* 56 */     return this.isNeedMonitor;
/*    */   }
/*    */   
/*    */   public void setNeedMonitor(Boolean needMonitor) {
/* 60 */     this.isNeedMonitor = needMonitor;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\BoxRouter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */