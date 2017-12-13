/*    */ package com.antbox.rfidmachine.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HTTPDownloadUtil
/*    */ {
/*    */   private HttpURLConnection httpConn;
/*    */   private InputStream inputStream;
/*    */   private String fileName;
/*    */   private int contentLength;
/*    */   
/*    */   public void downloadFile(String fileURL)
/*    */     throws IOException
/*    */   {
/* 21 */     URL url = new URL(fileURL);
/* 22 */     this.httpConn = ((HttpURLConnection)url.openConnection());
/* 23 */     int responseCode = this.httpConn.getResponseCode();
/*    */     
/*    */ 
/* 26 */     if (responseCode == 200) {
/* 27 */       String disposition = this.httpConn.getHeaderField("Content-Disposition");
/* 28 */       this.contentLength = this.httpConn.getContentLength();
/*    */       
/* 30 */       if (disposition != null) {
/* 31 */         int index = disposition.indexOf("filename=");
/* 32 */         if (index > 0) {
/* 33 */           this.fileName = disposition.substring(index + 10, disposition
/* 34 */             .length() - 1);
/*    */         }
/*    */       } else {
/* 37 */         this.fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL
/* 38 */           .length());
/*    */       }
/* 40 */       this.inputStream = this.httpConn.getInputStream();
/*    */     } else {
/* 42 */       throw new IOException("No file to download. Server replied HTTP code: " + responseCode);
/*    */     }
/*    */   }
/*    */   
/*    */   public void disconnect()
/*    */     throws IOException
/*    */   {
/* 49 */     this.inputStream.close();
/* 50 */     this.httpConn.disconnect();
/*    */   }
/*    */   
/*    */   public String getFileName() {
/* 54 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public int getContentLength() {
/* 58 */     return this.contentLength;
/*    */   }
/*    */   
/*    */   public InputStream getInputStream() {
/* 62 */     return this.inputStream;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\util\HTTPDownloadUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */