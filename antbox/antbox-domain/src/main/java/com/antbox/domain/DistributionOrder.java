/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.DistributionOrderStatus;
/*     */ import com.antbox.domain.enumclass.DistributionOrderType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_distribution_order")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class DistributionOrder
/*     */   extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(100) comment '配货单标题'")
/*     */   private String subject;
/*     */   @Column(columnDefinition="bigint comment '平台商id'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="bigint comment '加盟商id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="varchar(30) comment '加盟商名称'")
/*     */   private String merchantName;
/*     */   @Column(columnDefinition="varchar(30) comment '加盟商用户名称'")
/*     */   private String merchantUserName;
/*     */   @Column(columnDefinition="bigint comment '售货机id'")
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="varchar(30) comment '配货单号'")
/*     */   private String orderNum;
/*     */   @Column(columnDefinition="bigint comment '发起人商户用户id'")
/*     */   private Long initiatorMerchantUserId;
/*     */   @Column(columnDefinition="bigint comment '执行人商户用户id'")
/*     */   private Long executorMerchantUserId;
/*     */   @Column(columnDefinition="int(8) comment '实际上架数量'")
/*     */   private Integer actualInQty;
/*     */   @Column(columnDefinition="int(8) comment '实际下架数量'")
/*     */   private Integer actualOutQty;
/*     */   @Column(columnDefinition="int(8) comment '实际销售下架数量'")
/*     */   private Integer soldOutQty;
/*     */   @Column(columnDefinition="int(2) comment '状态 WAIT(0, \"待配货\"), PROCESSING(1, \"配货中\"), SUCCESS(2, \"完成\"), CANCEL(3, \"取消配货\")'")
/*     */   private DistributionOrderStatus status;
/*     */   @Column(columnDefinition="int(2) comment '状态 COMMON(0, \"正常配货\"), DYNAMIC(1, \"动态配货\")'")
/*     */   private DistributionOrderType type;
/*     */   
/*     */   public String getStatusText()
/*     */   {
/*  60 */     if (this.status != null) {
/*  61 */       return this.status.text;
/*     */     }
/*  63 */     return null;
/*     */   }
/*     */   
/*     */   public String getTypeText() {
/*  67 */     if (this.type != null) {
/*  68 */       return this.type.text;
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   public String getMerchantUserName() {
/*  74 */     return this.merchantUserName;
/*     */   }
/*     */   
/*     */   public void setMerchantUserName(String merchantUserName) {
/*  78 */     this.merchantUserName = merchantUserName;
/*     */   }
/*     */   
/*     */   public DistributionOrderType getType() {
/*  82 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(DistributionOrderType type) {
/*  86 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getSubject() {
/*  90 */     return this.subject;
/*     */   }
/*     */   
/*     */   public void setSubject(String subject) {
/*  94 */     this.subject = subject;
/*     */   }
/*     */   
/*     */   public DistributionOrderStatus getStatus() {
/*  98 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(DistributionOrderStatus status) {
/* 102 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 106 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 110 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 114 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 118 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getMerchantName() {
/* 122 */     return this.merchantName;
/*     */   }
/*     */   
/*     */   public void setMerchantName(String merchantName) {
/* 126 */     this.merchantName = merchantName;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/* 130 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/* 134 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public String getOrderNum() {
/* 138 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(String orderNum) {
/* 142 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   public Long getInitiatorMerchantUserId() {
/* 146 */     return this.initiatorMerchantUserId;
/*     */   }
/*     */   
/*     */   public void setInitiatorMerchantUserId(Long initiatorMerchantUserId) {
/* 150 */     this.initiatorMerchantUserId = initiatorMerchantUserId;
/*     */   }
/*     */   
/*     */   public Long getExecutorMerchantUserId() {
/* 154 */     return this.executorMerchantUserId;
/*     */   }
/*     */   
/*     */   public void setExecutorMerchantUserId(Long executorMerchantUserId) {
/* 158 */     this.executorMerchantUserId = executorMerchantUserId;
/*     */   }
/*     */   
/*     */   public Integer getActualInQty() {
/* 162 */     return this.actualInQty;
/*     */   }
/*     */   
/*     */   public void setActualInQty(Integer actualInQty) {
/* 166 */     this.actualInQty = actualInQty;
/*     */   }
/*     */   
/*     */   public Integer getActualOutQty() {
/* 170 */     return this.actualOutQty;
/*     */   }
/*     */   
/*     */   public Integer getSoldOutQty() {
/* 174 */     return this.soldOutQty;
/*     */   }
/*     */   
/*     */   public void setActualOutQty(Integer actualOutQty) {
/* 178 */     this.actualOutQty = actualOutQty;
/*     */   }
/*     */   
/*     */   public void setSoldOutQty(Integer soldOutQty) {
/* 182 */     this.soldOutQty = soldOutQty;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\DistributionOrder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */