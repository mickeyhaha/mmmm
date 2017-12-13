/*     */ package com.antbox.domain;
/*     */ 
/*     */ import com.antbox.common.IDEntity;
/*     */ import com.antbox.domain.enumclass.CustomerRegisterSource;
/*     */ import com.antbox.domain.enumclass.CustomerStatus;
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
/*     */ @Table(name="t_customer")
/*     */ @DynamicInsert
/*     */ @DynamicUpdate
/*     */ @Where(clause="deleted = 0")
/*     */ public class Customer
/*     */   extends IDEntity
/*     */ {
/*     */   public static final String ATTR_CLASS_NAME = "客户";
/*     */   @Column(columnDefinition="varchar(15) comment '手机号码'", unique=true)
/*     */   private String mobile;
/*     */   @Column(columnDefinition="varchar(30) comment '名称'")
/*     */   private String name;
/*     */   @Column(columnDefinition="int(2)  default 0 comment '状态 COMMON(0,\"正常\"), BLACK_LIST(1,\"黑名单\")'")
/*     */   private CustomerStatus status;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝唯一用户id'", unique=true)
/*     */   private String alipayUserId;
/*     */   @Column(columnDefinition="int(2) default 0 comment'支付宝免密支付协议 是否开通 1(\"是\"), 0(\"否\")'")
/*     */   private Boolean alipayFreePayment;
/*     */   @Column(columnDefinition="varchar(100) comment '支付宝免密支付协议 协议号'")
/*     */   private String alipayAgreementno;
/*     */   @Column(columnDefinition="varchar(100) comment '支付宝免密支付协议 外部签名号'")
/*     */   private String alipayAgreementExternalSignno;
/*     */   @Column(columnDefinition="varchar(50) comment '支付宝免密支付协议 签名时间'")
/*     */   private String alipayAgreementSignTime;
/*     */   @Column(columnDefinition="varchar(20) comment '首次注册售货机id'")
/*     */   private Long registerBoxId;
/*     */   @Column(columnDefinition="int(2) comment '首次注册来源 ALIPAY(0, \"支付宝\"), WECHAT(1, \"微信\"), THIRD_PARTY_APP(2, \"第三方\")'")
/*     */   private CustomerRegisterSource registerSource;
/*     */   @Column(columnDefinition="varchar(50) comment '微信 服务号 openid'")
/*     */   private String wechatOpenId;
/*     */   @Column(columnDefinition="bit default 0 comment'微信 免密支付协议 是否开通 1(\"是\"), 0(\"否\")'")
/*     */   private Boolean wechatFreePayment;
/*     */   @Column(columnDefinition="varchar(50) comment '微信 签约协议号'")
/*     */   private String wechatAgreementno;
/*     */   @Column(columnDefinition="varchar(50) comment '没支付订单号列表 json数组结构  正常：NULL , 有未支付订单：[\"103910130600382464\"]'")
/*     */   private String badOrderList;
/*     */   
/*     */   public Customer() {}
/*     */   
/*     */   public Customer(Long id)
/*     */   {
/*  63 */     super(id);
/*     */   }
/*     */   
/*     */   public String getWechatAgreementno()
/*     */   {
/*  68 */     return this.wechatAgreementno;
/*     */   }
/*     */   
/*     */   public void setWechatAgreementno(String wechatAgreementno) {
/*  72 */     this.wechatAgreementno = wechatAgreementno;
/*     */   }
/*     */   
/*     */   public Boolean getWechatFreePayment() {
/*  76 */     return this.wechatFreePayment;
/*     */   }
/*     */   
/*     */   public void setWechatFreePayment(Boolean wechatFreePayment) {
/*  80 */     this.wechatFreePayment = wechatFreePayment;
/*     */   }
/*     */   
/*     */   public String getAlipayAgreementno() {
/*  84 */     return this.alipayAgreementno;
/*     */   }
/*     */   
/*     */   public void setAlipayAgreementno(String alipayAgreementno) {
/*  88 */     this.alipayAgreementno = alipayAgreementno;
/*     */   }
/*     */   
/*     */   public String getAlipayAgreementExternalSignno() {
/*  92 */     return this.alipayAgreementExternalSignno;
/*     */   }
/*     */   
/*     */   public void setAlipayAgreementExternalSignno(String alipayAgreementExternalSignno) {
/*  96 */     this.alipayAgreementExternalSignno = alipayAgreementExternalSignno;
/*     */   }
/*     */   
/*     */   public String getAlipayAgreementSignTime() {
/* 100 */     return this.alipayAgreementSignTime;
/*     */   }
/*     */   
/*     */   public void setAlipayAgreementSignTime(String alipayAgreementSignTime) {
/* 104 */     this.alipayAgreementSignTime = alipayAgreementSignTime;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/* 108 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 112 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public String getAlipayUserId() {
/* 116 */     return this.alipayUserId;
/*     */   }
/*     */   
/*     */   public void setAlipayUserId(String alipayUserId) {
/* 120 */     this.alipayUserId = alipayUserId;
/*     */   }
/*     */   
/*     */   public Boolean getAlipayFreePayment() {
/* 124 */     return this.alipayFreePayment;
/*     */   }
/*     */   
/*     */   public void setAlipayFreePayment(Boolean alipayFreePayment) {
/* 128 */     this.alipayFreePayment = alipayFreePayment;
/*     */   }
/*     */   
/*     */   public CustomerStatus getStatus() {
/* 132 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(CustomerStatus status) {
/* 136 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getRegisterBoxId() {
/* 140 */     return this.registerBoxId;
/*     */   }
/*     */   
/*     */   public void setRegisterBoxId(Long registerBoxId) {
/* 144 */     this.registerBoxId = registerBoxId;
/*     */   }
/*     */   
/*     */   public CustomerRegisterSource getRegisterSource() {
/* 148 */     return this.registerSource;
/*     */   }
/*     */   
/*     */   public void setRegisterSource(CustomerRegisterSource registerSource) {
/* 152 */     this.registerSource = registerSource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 163 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name)
/*     */   {
/* 168 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getWechatOpenId()
/*     */   {
/* 178 */     return this.wechatOpenId;
/*     */   }
/*     */   
/*     */   public void setWechatOpenId(String wechatOpenId) {
/* 182 */     this.wechatOpenId = wechatOpenId;
/*     */   }
/*     */   
/*     */   public String getBadOrderList() {
/* 186 */     return this.badOrderList;
/*     */   }
/*     */   
/*     */   public void setBadOrderList(String badOrderList) {
/* 190 */     this.badOrderList = badOrderList;
/*     */   }
/*     */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\Customer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */