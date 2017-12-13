/*    */ package com.alipay.createandpay.httpclient;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import org.apache.commons.httpclient.Header;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpResponse
/*    */ {
/*    */   private Header[] responseHeaders;
/*    */   private String stringResult;
/*    */   private byte[] byteResult;
/*    */   
/*    */   public Header[] getResponseHeaders()
/*    */   {
/* 36 */     return this.responseHeaders;
/*    */   }
/*    */   
/*    */   public void setResponseHeaders(Header[] responseHeaders) {
/* 40 */     this.responseHeaders = responseHeaders;
/*    */   }
/*    */   
/*    */   public byte[] getByteResult() {
/* 44 */     if (this.byteResult != null) {
/* 45 */       return this.byteResult;
/*    */     }
/* 47 */     if (this.stringResult != null) {
/* 48 */       return this.stringResult.getBytes();
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public void setByteResult(byte[] byteResult) {
/* 54 */     this.byteResult = byteResult;
/*    */   }
/*    */   
/*    */   public String getStringResult() throws UnsupportedEncodingException {
/* 58 */     if (this.stringResult != null) {
/* 59 */       return this.stringResult;
/*    */     }
/* 61 */     if (this.byteResult != null) {
/* 62 */       return new String(this.byteResult, "utf-8");
/*    */     }
/* 64 */     return null;
/*    */   }
/*    */   
/*    */   public void setStringResult(String stringResult) {
/* 68 */     this.stringResult = stringResult;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\alipay\createandpay\httpclient\HttpResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */