/*     */ package com.antbox.domain.promotion;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.PromotionActivityStatus;
/*     */ import com.antbox.domain.enumclass.PromotionActivityType;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_promotion_activity")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class PromotionActivity
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition=" datetime comment '开始时间'", nullable=false)
/*     */   protected Date startTime;
/*     */   @Column(columnDefinition=" datetime comment '结束时间'", nullable=false)
/*     */   protected Date endTime;
/*     */   @Column(columnDefinition="bigint not null comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(100) comment '加盟商名字'")
/*     */   private String merchantName;
/*     */   @Column(columnDefinition="varchar(50) not null comment '活动号'")
/*     */   private String num;
/*     */   @Column(columnDefinition="varchar(75) comment '名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="varchar(45) comment '备注'")
/*     */   private String remark;
/*     */   @Column(columnDefinition="int(2) COMMENT 'ON(0,\"开启\"), OFF(1,\"关闭\")'")
/*     */   private PromotionActivityStatus status;
/*     */   @Column(columnDefinition="int(1)  NOT NULL DEFAULT 1 comment '是否所有盒子参与活动 1(true)/0(false)'")
/*     */   private Boolean hasAllBox;
/*     */   @Column(columnDefinition="int(2) COMMENT '类型'")
/*     */   private PromotionActivityType type;
/*     */   @Column(columnDefinition="bigint comment '最后编辑的运营商用户id'")
/*     */   private Long merchantUserId;
/*     */   @Column(columnDefinition="varchar(100) comment '最后编辑的运营商用户'")
/*     */   private String merchantUserName;
/*     */   
/*     */   public String getMerchantName()
/*     */   {
/*  52 */     return this.merchantName;
/*     */   }
/*     */   
/*     */   public void setMerchantName(String merchantName) {
/*  56 */     this.merchantName = merchantName;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/*  60 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/*  64 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public Long getMerchantUserId() {
/*  68 */     return this.merchantUserId;
/*     */   }
/*     */   
/*     */   public void setMerchantUserId(Long merchantUserId) {
/*  72 */     this.merchantUserId = merchantUserId;
/*     */   }
/*     */   
/*     */   public String getMerchantUserName() {
/*  76 */     return this.merchantUserName;
/*     */   }
/*     */   
/*     */   public void setMerchantUserName(String merchantUserName) {
/*  80 */     this.merchantUserName = merchantUserName;
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/*  84 */     return this.startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date startTime) {
/*  88 */     this.startTime = startTime;
/*     */   }
/*     */   
/*     */   public Date getEndTime() {
/*  92 */     return this.endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date endTime) {
/*  96 */     this.endTime = endTime;
/*     */   }
/*     */   
/*     */   public PromotionActivityType getType() {
/* 100 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(PromotionActivityType type) {
/* 104 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 108 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 112 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 116 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 120 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getNum() {
/* 124 */     return this.num;
/*     */   }
/*     */   
/*     */   public void setNum(String num) {
/* 128 */     this.num = num;
/*     */   }
/*     */   
/*     */   public PromotionActivityStatus getStatus() {
/* 132 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(PromotionActivityStatus status) {
/* 136 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Boolean getHasAllBox() {
/* 140 */     return this.hasAllBox;
/*     */   }
/*     */   
/*     */   public void setHasAllBox(Boolean hasAllBox) {
/* 144 */     this.hasAllBox = hasAllBox;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\promotion\PromotionActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */