/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.UploadFileType;
/*     */ import java.util.Calendar;
/*     */ import java.util.UUID;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.Transient;
/*     */ import org.hibernate.annotations.DynamicInsert;
/*     */ import org.hibernate.annotations.DynamicUpdate;
/*     */ 
/*     */ @Entity
/*     */ @javax.persistence.Table(name="t_upload_image_file")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ public class UploadImageFile extends IDEntity
/*     */ {
/*     */   @Column(columnDefinition="varchar(255) comment'文件名'")
/*     */   private String fileName;
/*     */   @Column(columnDefinition="varchar(255) comment'源文件文件名'")
/*     */   private String originFileName;
/*     */   @Column(columnDefinition="int comment '文件大小'")
/*     */   private Long size;
/*     */   @Column(columnDefinition="varchar(255) comment '文件路径 (可用于记录的唯一标识)'", unique=true)
/*     */   private String path;
/*     */   @Column(columnDefinition="varchar(50) comment '图片使用的业务类型 PRODUCT_FACE(\"/product/face\",\"产品封面图\")'")
/*     */   @Enumerated(EnumType.STRING)
/*     */   private UploadFileType fileType;
/*     */   @Column(columnDefinition="bigint comment '用户 id'")
/*     */   private Long userId;
/*     */   @Column(columnDefinition="bigint comment '商家 id'")
/*     */   private Long merchantId;
/*     */   @Column(columnDefinition="bigint comment '平台 id'")
/*     */   private Long mallId;
/*     */   @Transient
/*  39 */   private Calendar calendar = Calendar.getInstance();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String genFileName(String originalFilename)
/*     */   {
/*  48 */     StringBuffer fileName = new StringBuffer();
/*  49 */     fileName.append(this.calendar.get(5))
/*  50 */       .append(this.calendar.get(11))
/*  51 */       .append(this.calendar.get(12))
/*  52 */       .append(this.calendar.get(13))
/*  53 */       .append(this.calendar.get(14))
/*  54 */       .append(UUID.randomUUID().toString())
/*  55 */       .append(getExtFileName(originalFilename));
/*  56 */     return fileName.toString();
/*     */   }
/*     */   
/*     */   private String getExtFileName(String originFileName) {
/*  60 */     return originFileName.substring(originFileName.lastIndexOf("."));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String genAllPath(String env, UploadFileType businessType, String fileName)
/*     */   {
/*  71 */     StringBuffer path = new StringBuffer(env);
/*  72 */     path.append(businessType.getPath())
/*  73 */       .append("/")
/*  74 */       .append(this.calendar.get(1))
/*  75 */       .append(this.calendar.get(2) + 1)
/*  76 */       .append("/")
/*  77 */       .append(fileName);
/*  78 */     return path.toString();
/*     */   }
/*     */   
/*     */   public String getFileName() {
/*  82 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/*  86 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public String getOriginFileName() {
/*  90 */     return this.originFileName;
/*     */   }
/*     */   
/*     */   public void setOriginFileName(String originFileName) {
/*  94 */     this.originFileName = originFileName;
/*     */   }
/*     */   
/*     */   public Long getSize() {
/*  98 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(Long size) {
/* 102 */     this.size = size;
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 106 */     return this.path;
/*     */   }
/*     */   
/*     */   public void setPath(String path) {
/* 110 */     this.path = path;
/*     */   }
/*     */   
/*     */   public UploadFileType getFileType() {
/* 114 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public void setFileType(UploadFileType fileType) {
/* 118 */     this.fileType = fileType;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 122 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 126 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getMerchantId() {
/* 130 */     return this.merchantId;
/*     */   }
/*     */   
/*     */   public void setMerchantId(Long merchantId) {
/* 134 */     this.merchantId = merchantId;
/*     */   }
/*     */   
/*     */   public Long getMallId() {
/* 138 */     return this.mallId;
/*     */   }
/*     */   
/*     */   public void setMallId(Long mallId) {
/* 142 */     this.mallId = mallId;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 147 */     return "UploadImageFile{mallId=" + this.mallId + ", merchantId=" + this.merchantId + ", userId=" + this.userId + ", fileType=" + this.fileType + ", path='" + this.path + '\'' + ", size=" + this.size + ", originFileName='" + this.originFileName + '\'' + ", fileName='" + this.fileName + '\'' + '}';
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\UploadImageFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */