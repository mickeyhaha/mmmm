/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.CustomLongIDEntity;
/*     */ import com.antbox.domain.enumclass.BoxOperationStatus;
/*     */ import com.antbox.domain.enumclass.BoxStatus;
/*     */ import com.antbox.domain.enumclass.MallStatus;
/*     */ import com.antbox.domain.enumclass.MerchantStatus;
/*     */ import com.antbox.domain.enumclass.StoreStandardStatus;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ import org.hibernate.annotations.Where;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_box")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Box
/*     */   extends CustomLongIDEntity
/*     */ {
/*     */   public static final String REMIND_RECORD_BOX_ID_IS_EXIST = "机型ID已存在";
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="BIGINT COMMENT '平台ID'")
/*     */   private Long mallId;
/*     */   @Column(columnDefinition="VARCHAR(30) COMMENT '平台名称'")
/*     */   private String mallName;
/*     */   @Column(columnDefinition="BIGINT COMMENT '加盟商ID'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '运营中心控制状态 ENABLE(启用), DISABLE(停用)'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private BoxOperationStatus operationStatus;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '平台控制状态 ENABLE(启用), DISABLE(停用)'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private MallStatus mallStatus;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '加盟商控制状态 ENABLE(启用), DISABLE(停用)'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private MerchantStatus merchantStatus;
/*     */   @Column(columnDefinition="VARCHAR(50) COMMENT '机器状态 ONLINE(在线), OFFLINE(离线), BREAKDOWN(故障)'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private BoxStatus status;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '编号'")
/*     */   private String serialNumber;
/*     */   @Column(columnDefinition="VARCHAR(100) COMMENT '型号'")
/*     */   private String modelNumber;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '二维码图片地址'")
/*     */   private String qrCode;
/*     */   @Column(columnDefinition="INTEGER COMMENT '省ID'")
/*     */   private Integer provinceID;
/*     */   @Column(columnDefinition="INTEGER COMMENT '市ID'")
/*     */   private Integer cityID;
/*     */   @Column(columnDefinition="INTEGER COMMENT '区ID'")
/*     */   private Integer areaID;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '具体地址'")
/*     */   private String address;
/*     */   @Column(columnDefinition="VARCHAR(200) COMMENT '详细具体地址'")
/*     */   private String addressDetail;
/*     */   @Column(columnDefinition="int(2) default 0 COMMENT '是否开启标准库存设置状态 DISABLE(0,\"关闭\"), ENABLE(1,\"开启\")'")
/*     */   private StoreStandardStatus storeStandardStatus;
/*     */   
/*     */   public String getAddress()
/*     */   {
/*  69 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  73 */     this.address = address;
/*     */   }
/*     */   
/*     */   public Integer getProvinceID() {
/*  77 */     return this.provinceID;
/*     */   }
/*     */   
/*     */   public void setProvinceID(Integer provinceID) {
/*  81 */     this.provinceID = provinceID;
/*     */   }
/*     */   
/*     */   public Integer getCityID() {
/*  85 */     return this.cityID;
/*     */   }
/*     */   
/*     */   public void setCityID(Integer cityID) {
/*  89 */     this.cityID = cityID;
/*     */   }
/*     */   
/*     */   public Integer getAreaID() {
/*  93 */     return this.areaID;
/*     */   }
/*     */   
/*     */   public void setAreaID(Integer areaID) {
/*  97 */     this.areaID = areaID;
/*     */   }
/*     */   
/*     */   public String getMallName() {
/* 101 */     return this.mallName;
/*     */   }
/*     */   
/*     */   public void setMallName(String mallName) {
/* 105 */     this.mallName = mallName;
/*     */   }
/*     */   
/*     */   public String getModelNumber() {
/* 109 */     return this.modelNumber;
/*     */   }
/*     */   
/*     */   public void setModelNumber(String modelNumber) {
/* 113 */     this.modelNumber = modelNumber;
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 117 */     return this.serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String serialNumber) {
/* 121 */     this.serialNumber = serialNumber;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 125 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 129 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 133 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 137 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 141 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 145 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public BoxOperationStatus getOperationStatus() {
/* 149 */     return this.operationStatus;
/*     */   }
/*     */   
/*     */   public void setOperationStatus(BoxOperationStatus operationStatus) {
/* 153 */     this.operationStatus = operationStatus;
/*     */   }
/*     */   
/*     */   public MallStatus getMallStatus() {
/* 157 */     return this.mallStatus;
/*     */   }
/*     */   
/*     */   public void setMallStatus(MallStatus mallStatus) {
/* 161 */     this.mallStatus = mallStatus;
/*     */   }
/*     */   
/*     */   public MerchantStatus getMerchantStatus() {
/* 165 */     return this.merchantStatus;
/*     */   }
/*     */   
/*     */   public void setMerchantStatus(MerchantStatus merchantStatus) {
/* 169 */     this.merchantStatus = merchantStatus;
/*     */   }
/*     */   
/*     */   public BoxStatus getStatus() {
/* 173 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(BoxStatus status) {
/* 177 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getQrCode() {
/* 181 */     return this.qrCode;
/*     */   }
/*     */   
/*     */   public void setQrCode(String qrCode) {
/* 185 */     this.qrCode = qrCode;
/*     */   }
/*     */   
/*     */   public String getAddressDetail() {
/* 189 */     return this.addressDetail;
/*     */   }
/*     */   
/*     */   public void setAddressDetail(String addressDetail) {
/* 193 */     this.addressDetail = addressDetail;
/*     */   }
/*     */   
/*     */   public StoreStandardStatus getStoreStandardStatus() {
/* 197 */     return this.storeStandardStatus;
/*     */   }
/*     */   
/*     */   public void setStoreStandardStatus(StoreStandardStatus storeStandardStatus) {
/* 201 */     this.storeStandardStatus = storeStandardStatus;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Box.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */