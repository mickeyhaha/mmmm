/*    */ package com.antbox.domain;
/*    */ 
/*    */ import com.antbox.common.IDEntity;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.URLDecoder;
/*    */ import java.net.URLEncoder;
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
/*    */ @Entity
/*    */ @Table(name="t_customer_wechat")
/*    */ @DynamicInsert
/*    */ @DynamicUpdate
/*    */ @Where(clause="deleted = 0")
/*    */ public class CustomerWechat
/*    */   extends IDEntity
/*    */ {
/*    */   @Column(columnDefinition="bigint comment '客户id'")
/*    */   private Long customerId;
/*    */   @Column(columnDefinition="varchar(20) comment '手机号码'", unique=true)
/*    */   private String mobile;
/*    */   @Column(columnDefinition="varchar(50) comment '微信openid'", unique=true)
/*    */   private String wechatOpenId;
/*    */   @Column(columnDefinition="varchar(50) comment '微信 昵称'")
/*    */   private String wechatNickname;
/*    */   @Column(columnDefinition="varchar(255) comment '微信 头像'")
/*    */   private String wechatHeadImgUrl;
/*    */   @Column(columnDefinition="varchar(50) comment '签约协议号'")
/*    */   private String wechatAgreementno;
/*    */   
/*    */   public String getWechatHeadImgUrl()
/*    */   {
/* 40 */     return this.wechatHeadImgUrl;
/*    */   }
/*    */   
/*    */   public void setWechatHeadImgUrl(String wechatHeadImgUrl) {
/* 44 */     this.wechatHeadImgUrl = wechatHeadImgUrl;
/*    */   }
/*    */   
/*    */   public String getWechatOpenId() {
/* 48 */     return this.wechatOpenId;
/*    */   }
/*    */   
/*    */   public void setWechatOpenId(String wechatOpenId) {
/* 52 */     this.wechatOpenId = wechatOpenId;
/*    */   }
/*    */   
/*    */   public String getWechatNickname() {
/* 56 */     if (this.wechatNickname != null) {
/*    */       try {
/* 58 */         return URLDecoder.decode(this.wechatNickname, "UTF-8");
/*    */       }
/*    */       catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
/*    */     }
/*    */     
/* 63 */     return this.wechatNickname;
/*    */   }
/*    */   
/*    */   public void setWechatNickname(String wechatNickname) {
/* 67 */     if (wechatNickname != null) {
/*    */       try {
/* 69 */         this.wechatNickname = URLEncoder.encode(wechatNickname, "UTF-8");
/*    */       }
/*    */       catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
/*    */     }
/*    */   }
/*    */   
/*    */   public Long getCustomerId()
/*    */   {
/* 77 */     return this.customerId;
/*    */   }
/*    */   
/*    */   public void setCustomerId(Long customerId) {
/* 81 */     this.customerId = customerId;
/*    */   }
/*    */   
/*    */   public String getMobile() {
/* 85 */     return this.mobile;
/*    */   }
/*    */   
/*    */   public void setMobile(String mobile) {
/* 89 */     this.mobile = mobile;
/*    */   }
/*    */   
/*    */   public String getWechatAgreementno() {
/* 93 */     return this.wechatAgreementno;
/*    */   }
/*    */   
/*    */   public void setWechatAgreementno(String wechatAgreementno) {
/* 97 */     this.wechatAgreementno = wechatAgreementno;
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\CustomerWechat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */