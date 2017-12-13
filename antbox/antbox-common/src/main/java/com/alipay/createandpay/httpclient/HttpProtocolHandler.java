/*     */ package com.alipay.createandpay.httpclient;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.httpclient.HttpClient;
/*     */ import org.apache.commons.httpclient.HttpConnectionManager;
/*     */ import org.apache.commons.httpclient.HttpException;
/*     */ import org.apache.commons.httpclient.HttpMethod;
/*     */ import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
/*     */ import org.apache.commons.httpclient.NameValuePair;
/*     */ import org.apache.commons.httpclient.methods.GetMethod;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.apache.commons.httpclient.methods.multipart.FilePart;
/*     */ import org.apache.commons.httpclient.methods.multipart.FilePartSource;
/*     */ import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
/*     */ import org.apache.commons.httpclient.methods.multipart.Part;
/*     */ import org.apache.commons.httpclient.methods.multipart.StringPart;
/*     */ import org.apache.commons.httpclient.params.HttpClientParams;
/*     */ import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
/*     */ import org.apache.commons.httpclient.params.HttpMethodParams;
/*     */ import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;
/*     */ 
/*     */ 
/*     */ public class HttpProtocolHandler
/*     */ {
/*  29 */   private static String DEFAULT_CHARSET = "GBK";
/*     */   
/*     */ 
/*  32 */   private int defaultConnectionTimeout = 8000;
/*     */   
/*     */ 
/*  35 */   private int defaultSoTimeout = 30000;
/*     */   
/*     */ 
/*  38 */   private int defaultIdleConnTimeout = 60000;
/*     */   
/*  40 */   private int defaultMaxConnPerHost = 30;
/*     */   
/*  42 */   private int defaultMaxTotalConn = 80;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final long defaultHttpConnectionManagerTimeout = 3000L;
/*     */   
/*     */ 
/*     */   private HttpConnectionManager connectionManager;
/*     */   
/*     */ 
/*  52 */   private static HttpProtocolHandler httpProtocolHandler = new HttpProtocolHandler();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static HttpProtocolHandler getInstance()
/*     */   {
/*  60 */     return httpProtocolHandler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private HttpProtocolHandler()
/*     */   {
/*  68 */     this.connectionManager = new MultiThreadedHttpConnectionManager();
/*  69 */     this.connectionManager.getParams().setDefaultMaxConnectionsPerHost(this.defaultMaxConnPerHost);
/*  70 */     this.connectionManager.getParams().setMaxTotalConnections(this.defaultMaxTotalConn);
/*     */     
/*  72 */     IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
/*  73 */     ict.addConnectionManager(this.connectionManager);
/*  74 */     ict.setConnectionTimeout(this.defaultIdleConnTimeout);
/*     */     
/*  76 */     ict.start();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HttpResponse execute(HttpRequest request, String strParaFileName, String strFilePath)
/*     */     throws HttpException, IOException
/*     */   {
/*  89 */     HttpClient httpclient = new HttpClient(this.connectionManager);
/*     */     
/*     */ 
/*  92 */     int connectionTimeout = this.defaultConnectionTimeout;
/*  93 */     if (request.getConnectionTimeout() > 0) {
/*  94 */       connectionTimeout = request.getConnectionTimeout();
/*     */     }
/*  96 */     httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
/*     */     
/*     */ 
/*  99 */     int soTimeout = this.defaultSoTimeout;
/* 100 */     if (request.getTimeout() > 0) {
/* 101 */       soTimeout = request.getTimeout();
/*     */     }
/* 103 */     httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);
/*     */     
/*     */ 
/* 106 */     httpclient.getParams().setConnectionManagerTimeout(3000L);
/*     */     
/* 108 */     String charset = request.getCharset();
/* 109 */     charset = charset == null ? DEFAULT_CHARSET : charset;
/* 110 */     HttpMethod method = null;
/*     */     
/*     */ 
/* 113 */     if (request.getMethod().equals("GET")) {
/* 114 */       method = new GetMethod(request.getUrl());
/* 115 */       method.getParams().setCredentialCharset(charset);
/*     */       
/*     */ 
/* 118 */       method.setQueryString(request.getQueryString());
/* 119 */     } else if ((strParaFileName.equals("")) && (strFilePath.equals("")))
/*     */     {
/* 121 */       method = new PostMethod(request.getUrl());
/* 122 */       ((PostMethod)method).addParameters(request.getParameters());
/* 123 */       method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=" + charset);
/*     */     }
/*     */     else
/*     */     {
/* 127 */       method = new PostMethod(request.getUrl());
/* 128 */       List<Part> parts = new ArrayList();
/* 129 */       for (int i = 0; i < request.getParameters().length; i++) {
/* 130 */         parts.add(new StringPart(request.getParameters()[i].getName(), request.getParameters()[i].getValue(), charset));
/*     */       }
/*     */       
/* 133 */       parts.add(new FilePart(strParaFileName, new FilePartSource(new File(strFilePath))));
/*     */       
/*     */ 
/* 136 */       ((PostMethod)method).setRequestEntity(new MultipartRequestEntity((Part[])parts.toArray(new Part[0]), new HttpMethodParams()));
/*     */     }
/*     */     
/*     */ 
/* 140 */     method.addRequestHeader("User-Agent", "Mozilla/4.0");
/* 141 */     HttpResponse response = new HttpResponse();
/*     */     try
/*     */     {
/* 144 */       httpclient.executeMethod(method);
/* 145 */       if (request.getResultType().equals(HttpResultType.STRING)) {
/* 146 */         response.setStringResult(method.getResponseBodyAsString());
/* 147 */       } else if (request.getResultType().equals(HttpResultType.BYTES)) {
/* 148 */         response.setByteResult(method.getResponseBody());
/*     */       }
/* 150 */       response.setResponseHeaders(method.getResponseHeaders());
/*     */     }
/*     */     catch (UnknownHostException ex) {
/* 153 */       return null;
/*     */     }
/*     */     catch (IOException ex) {
/* 156 */       return null;
/*     */     } catch (Exception ex) {
/*     */       HttpResponse localHttpResponse1;
/* 159 */       return null;
/*     */     } finally {
/* 161 */       method.releaseConnection();
/*     */     }
/* 163 */     return response;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String toString(NameValuePair[] nameValues)
/*     */   {
/* 173 */     if ((nameValues == null) || (nameValues.length == 0)) {
/* 174 */       return "null";
/*     */     }
/*     */     
/* 177 */     StringBuffer buffer = new StringBuffer();
/*     */     
/* 179 */     for (int i = 0; i < nameValues.length; i++) {
/* 180 */       NameValuePair nameValue = nameValues[i];
/*     */       
/* 182 */       if (i == 0) {
/* 183 */         buffer.append(nameValue.getName() + "=" + nameValue.getValue());
/*     */       } else {
/* 185 */         buffer.append("&" + nameValue.getName() + "=" + nameValue.getValue());
/*     */       }
/*     */     }
/*     */     
/* 189 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\alipay\createandpay\httpclient\HttpProtocolHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */