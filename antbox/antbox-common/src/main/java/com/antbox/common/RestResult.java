/*     */ package com.antbox.common;
/*     */ 
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RestResult<T>
/*     */ {
/*  11 */   public static final String[] CD3 = { "3", "温馨提示:" };
/*  12 */   public static final String[] CD2 = { "2", "参数错误:" };
/*  13 */   public static final String[] CD1 = { "1", "成功" };
/*  14 */   public static final String[] CD0 = { "0", "失败" };
/*     */   
/*  16 */   public static final String[] CD101 = { "101", "用户名不存在" };
/*  17 */   public static final String[] CD102 = { "102", "用户名状态异常" };
/*  18 */   public static final String[] CD103 = { "103", "密码错误" };
/*  19 */   public static final String[] CD104 = { "104", "access_token 不能为空" };
/*  20 */   public static final String[] CD105 = { "105", "access_token 无效" };
/*  21 */   public static final String[] CD106 = { "106", "用户名不能为空" };
/*  22 */   public static final String[] CD107 = { "107", "您没有登录权限" };
/*  23 */   public static final String[] CD108 = { "108", "domain 不能为空" };
/*  24 */   public static final String[] CD109 = { "109", "用户会话已过期" };
/*  25 */   public static final String[] CD110 = { "110", "账户被禁用，请联系管理员" };
/*  26 */   public static final String[] CD111 = { "111", "您没有权限" };
/*  27 */   public static final String[] CD112 = { "112", "域名不存在" };
/*     */   
/*     */   public RestResult() {}
/*     */   
/*     */   public RestResult(String code, String desc)
/*     */   {
/*  33 */     this.code = code;
/*  34 */     this.desc = desc;
/*     */   }
/*     */   
/*     */   public RestResult(String code, String desc, T data) {
/*  38 */     this.code = code;
/*  39 */     this.desc = desc;
/*  40 */     this.data = data;
/*     */   }
/*     */   
/*     */   public void remind(String desc) {
/*  44 */     remind(desc, null);
/*     */   }
/*     */   
/*     */   public void remind(String desc, Logger log) {
/*  48 */     this.code = CD3[0];
/*  49 */     this.desc = (CD3[1] + desc);
/*  50 */     if (log != null) {
/*  51 */       log.warn("remind , desc : {}", desc);
/*     */     }
/*     */   }
/*     */   
/*     */   public void errorParam(String desc) {
/*  56 */     errorParam(desc, null);
/*     */   }
/*     */   
/*     */   public void errorParam(String desc, Logger log) {
/*  60 */     this.code = CD2[0];
/*  61 */     this.desc = (CD2[1] + desc);
/*  62 */     if (log != null)
/*  63 */       log.warn("errorParam , desc : {}", desc);
/*     */   }
/*     */   
/*     */   public void custom(String code, String desc) {
/*  67 */     custom(code, desc, null);
/*     */   }
/*     */   
/*     */   public void custom(String code, String desc, Logger log) {
/*  71 */     this.code = code;
/*  72 */     this.desc = desc;
/*  73 */     if (log != null) {
/*  74 */       log.warn("custom , code : {} , desc : {}", code, desc);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  79 */   public String code = CD1[0];
/*  80 */   public String desc = CD1[1];
/*     */   public T data;
/*     */   
/*     */   public String getCode() {
/*  84 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  88 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getDesc() {
/*  92 */     return this.desc;
/*     */   }
/*     */   
/*     */   public void setDesc(String desc) {
/*  96 */     this.desc = desc;
/*     */   }
/*     */   
/*     */   public T getData() {
/* 100 */     return (T)this.data;
/*     */   }
/*     */   
/*     */   public void setData(T data) {
/* 104 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 109 */     return "RestResult{code='" + this.code + '\'' + ", desc='" + this.desc + '\'' + ", list=" + this.data + '}';
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RestResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */