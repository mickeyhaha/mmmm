/*     */ package com.antbox.domain.store;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.StoreStandardStatus;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_store_standard")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Standard
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String REMIND_BOX_ID_IS_NULL = "boxId为空";
/*     */   public static final String REMIND_STATUS_IS_NULL = "status为空";
/*     */   public static final String REMIND_MERCHANT_ID_IS_NULL = "merchantId为空";
/*     */   @Column(columnDefinition="int(2) default 0 COMMENT '状态 DISABLE(0,\"关闭\"), ENABLE(1,\"开启\")'", nullable=false)
/*     */   private StoreStandardStatus status;
/*     */   @Column(name="merchant_id", columnDefinition="bigint COMMENT '运营商ID'", nullable=false)
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint COMMENT '平台商ID'", nullable=false)
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '运营商名称'")
/*     */   private String merchantName;
/*     */   @Column(name="box_id", columnDefinition="bigint COMMENT '售货机ID'", nullable=false)
/*     */   private Long boxId;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '售货机名称'")
/*     */   private String boxName;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '售货机编号'")
/*     */   private String boxSerialNumber;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '售货机型号'")
/*     */   private String boxModelNumber;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '售货机详细具体地址'")
/*     */   private String boxAddressDetail;
/*     */   
/*     */   public StoreStandardStatus getStatus()
/*     */   {
/*  54 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(StoreStandardStatus status) {
/*  58 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/*  62 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/*  66 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public String getMerchantName() {
/*  70 */     return this.merchantName;
/*     */   }
/*     */   
/*     */   public void setMerchantName(String merchantName) {
/*  74 */     this.merchantName = merchantName;
/*     */   }
/*     */   
/*     */   public Long getBoxId() {
/*  78 */     return this.boxId;
/*     */   }
/*     */   
/*     */   public void setBoxId(Long boxId) {
/*  82 */     this.boxId = boxId;
/*     */   }
/*     */   
/*     */   public String getBoxName() {
/*  86 */     return this.boxName;
/*     */   }
/*     */   
/*     */   public void setBoxName(String boxName) {
/*  90 */     this.boxName = boxName;
/*     */   }
/*     */   
/*     */   public String getBoxSerialNumber() {
/*  94 */     return this.boxSerialNumber;
/*     */   }
/*     */   
/*     */   public void setBoxSerialNumber(String boxSerialNumber) {
/*  98 */     this.boxSerialNumber = boxSerialNumber;
/*     */   }
/*     */   
/*     */   public String getBoxModelNumber() {
/* 102 */     return this.boxModelNumber;
/*     */   }
/*     */   
/*     */   public void setBoxModelNumber(String boxModelNumber) {
/* 106 */     this.boxModelNumber = boxModelNumber;
/*     */   }
/*     */   
/*     */   public String getBoxAddressDetail() {
/* 110 */     return this.boxAddressDetail;
/*     */   }
/*     */   
/*     */   public void setBoxAddressDetail(String boxAddressDetail) {
/* 114 */     this.boxAddressDetail = boxAddressDetail;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 118 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 122 */     this.mallId = mallId;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\store\Standard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */