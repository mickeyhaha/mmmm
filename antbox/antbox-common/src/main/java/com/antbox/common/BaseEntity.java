/*     */ package com.antbox.common;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*     */ import com.fasterxml.jackson.annotation.JsonInclude;
/*     */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.MappedSuperclass;
/*     */ import javax.persistence.Transient;
/*     */ import javax.persistence.Version;
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
/*     */ @MappedSuperclass
/*     */ @JsonInclude(JsonInclude.Include.NON_NULL)
/*     */ @JsonIgnoreProperties(value={"updatedAt", "deleted", "version", "createdAt"}, ignoreUnknown=true)
/*     */ public class BaseEntity
/*     */   implements Serializable
/*     */ {
/*     */   public static final String CHECK_ID_IS_NOT_NULL = "id 不能为空";
/*     */   public static final String CHECK_BODY_IS_NOT_NULL = "body 不能为空";
/*     */   public static final String REMIND_RECORD_IS_NOT_EXIST = "记录不存在";
/*     */   public static final String REMIND_RECORD_IS_EXIST = "记录已存在";
/*     */   public static final String REMIND_ID_IS_NOT_NULL = "ID不存在";
/*     */   public static final String ATTR_PAGE = "page";
/*     */   public static final String ATTR_DOMAIN = "domain";
/*     */   public static final String ATTR_HOST = "Host";
/*     */   public static final String DELETED_CLAUSE = "deleted = 0";
/*     */   public static final String DEFAULT_ORDER_FIELD = "createdAt";
/*     */   private static final long serialVersionUID = 5009924268072869328L;
/*     */   @Column(columnDefinition=" bigint comment '创建时间'", nullable=false)
/*     */   protected Long createdAt;
/*     */   @Column(columnDefinition=" bigint comment '更新时间'", nullable=false)
/*     */   protected Long updatedAt;
/*     */   @Column(columnDefinition="bit default 0 comment '是否逻辑删除 (是:1,否:0)'", nullable=false)
/*     */   protected Boolean deleted;
/*     */   @Version
/*     */   @Column(columnDefinition="bigint default 0 comment '记录版本号'")
/*     */   protected Long version;
/*     */   @Transient
/*     */   protected Integer pageNo;
/*     */   @Transient
/*     */   protected Integer pageSize;
/*     */   @Transient
/*     */   protected String domain;
/*     */   @Transient
/*     */   protected String accessToken;
/*     */   @Transient
/*     */   protected Date createdTime;
/*     */   
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getCreatedTime()
/*     */   {
/*  74 */     if (this.createdAt != null) {
/*  75 */       return new Date(this.createdAt.longValue());
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */   
/*     */   public String getDomain() {
/*  81 */     if (null != this.domain) {
/*  82 */       return this.domain.replace(".local.", ".dev.");
/*     */     }
/*  84 */     return null;
/*     */   }
/*     */   
/*     */   public void setDomain(String domain) {
/*  88 */     this.domain = domain;
/*     */   }
/*     */   
/*     */   public String getAccessToken() {
/*  92 */     return this.accessToken;
/*     */   }
/*     */   
/*     */   public void setAccessToken(String accessToken) {
/*  96 */     this.accessToken = accessToken;
/*     */   }
/*     */   
/*     */   public Long getCreatedAt() {
/* 100 */     return this.createdAt;
/*     */   }
/*     */   
/*     */   public void setCreatedAt(Long createdAt) {
/* 104 */     this.createdAt = createdAt;
/*     */   }
/*     */   
/*     */   public Long getUpdatedAt() {
/* 108 */     return this.updatedAt;
/*     */   }
/*     */   
/*     */   public void setUpdatedAt(Long updatedAt) {
/* 112 */     this.updatedAt = updatedAt;
/*     */   }
/*     */   
/*     */   public Integer getPageNo() {
/* 116 */     return this.pageNo;
/*     */   }
/*     */   
/*     */   public void setPageNo(Integer pageNo) {
/* 120 */     this.pageNo = pageNo;
/*     */   }
/*     */   
/*     */   public Integer getPageSize() {
/* 124 */     return this.pageSize;
/*     */   }
/*     */   
/*     */   public void setPageSize(Integer pageSize) {
/* 128 */     this.pageSize = pageSize;
/*     */   }
/*     */   
/*     */   public Long getVersion() {
/* 132 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(Long version) {
/* 136 */     this.version = version;
/*     */   }
/*     */   
/*     */   public Boolean getDeleted() {
/* 140 */     return this.deleted;
/*     */   }
/*     */   
/*     */   public void setDeleted(Boolean deleted) {
/* 144 */     this.deleted = deleted;
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\BaseEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */