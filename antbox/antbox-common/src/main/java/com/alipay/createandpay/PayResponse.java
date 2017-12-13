/*     */ package com.alipay.createandpay;
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
/*     */ public class PayResponse
/*     */   extends PayBean
/*     */ {
/*     */   String agreement_no;
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
/*     */   String external_sign_no;
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
/*     */   private String is_success;
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
/*     */   private String sign_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String sign;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String exterface;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_time;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String trade_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String trade_status;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String seller_email;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String buyer_email;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String seller_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String buyer_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String alipay_user_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String gmt_payment;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String extra_common_param;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String notify_action_type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String gmt_create;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String body;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String out_biz_no;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String paytools_pay_amount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String error;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String result_code;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String buyer_user_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String buyer_logon_id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String detail_error_code;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String detail_error_des;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String extend_info;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String fund_bill_list;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String price;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Integer quantity;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String refund_fee;
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
/*     */   public String getAgreement_no()
/*     */   {
/* 362 */     return this.agreement_no;
/*     */   }
/*     */   
/*     */   public void setAgreement_no(String agreement_no) {
/* 366 */     this.agreement_no = agreement_no;
/*     */   }
/*     */   
/*     */   public String getExternal_sign_no() {
/* 370 */     return this.external_sign_no;
/*     */   }
/*     */   
/*     */   public void setExternal_sign_no(String external_sign_no) {
/* 374 */     this.external_sign_no = external_sign_no;
/*     */   }
/*     */   
/*     */   public String getIs_success() {
/* 378 */     return this.is_success;
/*     */   }
/*     */   
/*     */   public void setIs_success(String is_success) {
/* 382 */     this.is_success = is_success;
/*     */   }
/*     */   
/*     */   public String getSign_type() {
/* 386 */     return this.sign_type;
/*     */   }
/*     */   
/*     */   public void setSign_type(String sign_type) {
/* 390 */     this.sign_type = sign_type;
/*     */   }
/*     */   
/*     */   public String getSign() {
/* 394 */     return this.sign;
/*     */   }
/*     */   
/*     */   public void setSign(String sign) {
/* 398 */     this.sign = sign;
/*     */   }
/*     */   
/*     */   public String getExterface() {
/* 402 */     return this.exterface;
/*     */   }
/*     */   
/*     */   public void setExterface(String exterface) {
/* 406 */     this.exterface = exterface;
/*     */   }
/*     */   
/*     */   public String getNotify_id() {
/* 410 */     return this.notify_id;
/*     */   }
/*     */   
/*     */   public void setNotify_id(String notify_id) {
/* 414 */     this.notify_id = notify_id;
/*     */   }
/*     */   
/*     */   public String getNotify_time() {
/* 418 */     return this.notify_time;
/*     */   }
/*     */   
/*     */   public void setNotify_time(String notify_time) {
/* 422 */     this.notify_time = notify_time;
/*     */   }
/*     */   
/*     */   public String getNotify_type() {
/* 426 */     return this.notify_type;
/*     */   }
/*     */   
/*     */   public void setNotify_type(String notify_type) {
/* 430 */     this.notify_type = notify_type;
/*     */   }
/*     */   
/*     */   public String getTrade_no() {
/* 434 */     return this.trade_no;
/*     */   }
/*     */   
/*     */   public void setTrade_no(String trade_no) {
/* 438 */     this.trade_no = trade_no;
/*     */   }
/*     */   
/*     */   public String getTrade_status() {
/* 442 */     return this.trade_status;
/*     */   }
/*     */   
/*     */   public void setTrade_status(String trade_status) {
/* 446 */     this.trade_status = trade_status;
/*     */   }
/*     */   
/*     */   public String getSeller_email() {
/* 450 */     return this.seller_email;
/*     */   }
/*     */   
/*     */   public void setSeller_email(String seller_email) {
/* 454 */     this.seller_email = seller_email;
/*     */   }
/*     */   
/*     */   public String getBuyer_email() {
/* 458 */     return this.buyer_email;
/*     */   }
/*     */   
/*     */   public void setBuyer_email(String buyer_email) {
/* 462 */     this.buyer_email = buyer_email;
/*     */   }
/*     */   
/*     */   public String getSeller_id() {
/* 466 */     return this.seller_id;
/*     */   }
/*     */   
/*     */   public void setSeller_id(String seller_id) {
/* 470 */     this.seller_id = seller_id;
/*     */   }
/*     */   
/*     */   public String getBuyer_id() {
/* 474 */     return this.buyer_id;
/*     */   }
/*     */   
/*     */   public void setBuyer_id(String buyer_id) {
/* 478 */     this.buyer_id = buyer_id;
/*     */   }
/*     */   
/*     */   public String getGmt_payment() {
/* 482 */     return this.gmt_payment;
/*     */   }
/*     */   
/*     */   public void setGmt_payment(String gmt_payment) {
/* 486 */     this.gmt_payment = gmt_payment;
/*     */   }
/*     */   
/*     */   public String getExtra_common_param() {
/* 490 */     return this.extra_common_param;
/*     */   }
/*     */   
/*     */   public void setExtra_common_param(String extra_common_param) {
/* 494 */     this.extra_common_param = extra_common_param;
/*     */   }
/*     */   
/*     */   public String getNotify_action_type() {
/* 498 */     return this.notify_action_type;
/*     */   }
/*     */   
/*     */   public void setNotify_action_type(String notify_action_type) {
/* 502 */     this.notify_action_type = notify_action_type;
/*     */   }
/*     */   
/*     */   public String getGmt_create() {
/* 506 */     return this.gmt_create;
/*     */   }
/*     */   
/*     */   public void setGmt_create(String gmt_create) {
/* 510 */     this.gmt_create = gmt_create;
/*     */   }
/*     */   
/*     */   public String getBody() {
/* 514 */     return this.body;
/*     */   }
/*     */   
/*     */   public void setBody(String body) {
/* 518 */     this.body = body;
/*     */   }
/*     */   
/*     */   public String getOut_biz_no() {
/* 522 */     return this.out_biz_no;
/*     */   }
/*     */   
/*     */   public void setOut_biz_no(String out_biz_no) {
/* 526 */     this.out_biz_no = out_biz_no;
/*     */   }
/*     */   
/*     */   public String getPaytools_pay_amount() {
/* 530 */     return this.paytools_pay_amount;
/*     */   }
/*     */   
/*     */   public void setPaytools_pay_amount(String paytools_pay_amount) {
/* 534 */     this.paytools_pay_amount = paytools_pay_amount;
/*     */   }
/*     */   
/*     */   public String getError() {
/* 538 */     return this.error;
/*     */   }
/*     */   
/*     */   public void setError(String error) {
/* 542 */     this.error = error;
/*     */   }
/*     */   
/*     */   public String getResult_code() {
/* 546 */     return this.result_code;
/*     */   }
/*     */   
/*     */   public void setResult_code(String result_code) {
/* 550 */     this.result_code = result_code;
/*     */   }
/*     */   
/*     */   public String getBuyer_user_id() {
/* 554 */     return this.buyer_user_id;
/*     */   }
/*     */   
/*     */   public void setBuyer_user_id(String buyer_user_id) {
/* 558 */     this.buyer_user_id = buyer_user_id;
/*     */   }
/*     */   
/*     */   public String getBuyer_logon_id() {
/* 562 */     return this.buyer_logon_id;
/*     */   }
/*     */   
/*     */   public void setBuyer_logon_id(String buyer_logon_id) {
/* 566 */     this.buyer_logon_id = buyer_logon_id;
/*     */   }
/*     */   
/*     */   public String getDetail_error_code() {
/* 570 */     return this.detail_error_code;
/*     */   }
/*     */   
/*     */   public void setDetail_error_code(String detail_error_code) {
/* 574 */     this.detail_error_code = detail_error_code;
/*     */   }
/*     */   
/*     */   public String getDetail_error_des() {
/* 578 */     return this.detail_error_des;
/*     */   }
/*     */   
/*     */   public void setDetail_error_des(String detail_error_des) {
/* 582 */     this.detail_error_des = detail_error_des;
/*     */   }
/*     */   
/*     */   public String getExtend_info() {
/* 586 */     return this.extend_info;
/*     */   }
/*     */   
/*     */   public void setExtend_info(String extend_info) {
/* 590 */     this.extend_info = extend_info;
/*     */   }
/*     */   
/*     */   public String getFund_bill_list() {
/* 594 */     return this.fund_bill_list;
/*     */   }
/*     */   
/*     */   public void setFund_bill_list(String fund_bill_list) {
/* 598 */     this.fund_bill_list = fund_bill_list;
/*     */   }
/*     */   
/*     */   public String getPrice() {
/* 602 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(String price) {
/* 606 */     this.price = price;
/*     */   }
/*     */   
/*     */   public Integer getQuantity() {
/* 610 */     return this.quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(Integer quantity) {
/* 614 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */   public String getRefund_fee() {
/* 618 */     return this.refund_fee;
/*     */   }
/*     */   
/*     */   public void setRefund_fee(String refund_fee) {
/* 622 */     this.refund_fee = refund_fee;
/*     */   }
/*     */   
/*     */   public String getAlipay_user_id() {
/* 626 */     return this.alipay_user_id;
/*     */   }
/*     */   
/*     */   public void setAlipay_user_id(String alipay_user_id) {
/* 630 */     this.alipay_user_id = alipay_user_id;
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\alipay\createandpay\PayResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */