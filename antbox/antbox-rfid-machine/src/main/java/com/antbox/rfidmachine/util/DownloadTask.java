/*     */ package com.antbox.rfidmachine.util;
/*     */ 
/*     */ import com.antbox.rfidmachine.swing.DownloadJarTable;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.security.CodeSource;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.List;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.SwingWorker;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DownloadTask
/*     */   extends SwingWorker<Void, Void>
/*     */ {
/*     */   private static final int BUFFER_SIZE = 4096;
/*     */   private DownloadJarTable gui;
/*     */   private String newDependJar;
/*     */   private String oldDependJar;
/*     */   private String saveFilePath;
/*  33 */   ObjectMapper objectMapper = new ObjectMapper();
/*     */   
/*     */   public DownloadTask(DownloadJarTable gui, String newDependJar, String oldDependJar)
/*     */   {
/*  37 */     this.gui = gui;
/*  38 */     this.newDependJar = newDependJar;
/*  39 */     this.oldDependJar = oldDependJar;
/*  40 */     this.saveFilePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
/*  41 */     this.saveFilePath = this.saveFilePath.split("antbox-rfid-machine.jar")[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Void doInBackground()
/*     */     throws Exception
/*     */   {
/*  50 */     String downloadUrl = "http://assert.mayihezi.com/prod/rfid_machine_jar/";
/*     */     try {
/*  52 */       HTTPDownloadUtil util = new HTTPDownloadUtil();
/*     */       
/*  54 */       byte[] buffer = new byte['က'];
/*  55 */       int bytesRead = -1;
/*  56 */       long totalBytesRead = 0L;
/*  57 */       int percentCompleted = 0;
/*     */       
/*     */ 
/*  60 */       util.downloadFile(downloadUrl + "antbox-rfid-machine.jar");
/*  61 */       InputStream inputStream = util.getInputStream();
/*  62 */       FileOutputStream outputStream = new FileOutputStream(this.saveFilePath + File.separator + util.getFileName());
/*  63 */       long fileSize = util.getContentLength();
/*  64 */       while ((bytesRead = inputStream.read(buffer)) != -1) {
/*  65 */         outputStream.write(buffer, 0, bytesRead);
/*  66 */         totalBytesRead += bytesRead;
/*  67 */         percentCompleted = (int)(totalBytesRead * 100L / fileSize);
/*  68 */         setProgress(percentCompleted);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  73 */       if (StringUtils.isNotBlank(this.oldDependJar)) {
/*  74 */         List<String> oldJars = (List)this.objectMapper.readValue(this.oldDependJar, new TypeReference() {});
/*  75 */         for (String oldJar : oldJars) {
/*  76 */           oldPath = this.saveFilePath + "/lib/" + oldJar;
/*  77 */           File file = new File(oldPath);
/*  78 */           if (file.exists()) {
/*  79 */             file.delete();
/*     */           }
/*     */         }
/*     */       }
/*     */       String oldPath;
/*     */       long totalOs;
/*  85 */       if (StringUtils.isNotBlank(this.newDependJar)) {
/*  86 */         totalOs = 0L;
/*  87 */         List<String> newJars = (List)this.objectMapper.readValue(this.newDependJar, new TypeReference() {});
/*  88 */         for (String newJar : newJars) {
/*  89 */           setProgress(0);
/*  90 */           if (percentCompleted == 100) {
/*  91 */             totalOs = 0L;
/*     */           }
/*  93 */           util.downloadFile(downloadUrl + newJar);
/*  94 */           InputStream is = util.getInputStream();
/*  95 */           FileOutputStream os = new FileOutputStream(this.saveFilePath + "/lib/" + File.separator + util.getFileName());
/*  96 */           long fileOs = util.getContentLength();
/*  97 */           while ((bytesRead = is.read(buffer)) != -1) {
/*  98 */             os.write(buffer, 0, bytesRead);
/*  99 */             totalOs += bytesRead;
/* 100 */             percentCompleted = (int)(totalOs * 100L / fileOs);
/* 101 */             setProgress(percentCompleted);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 107 */       outputStream.close();
/* 108 */       util.disconnect();
/*     */     } catch (IOException ex) {
/* 110 */       JOptionPane.showMessageDialog(this.gui, "Error downloading file: " + ex.getMessage(), "Error", 0);
/*     */       
/* 112 */       ex.printStackTrace();
/* 113 */       setProgress(0);
/* 114 */       cancel(true);
/*     */     }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void done()
/*     */   {
/* 124 */     if (!isCancelled()) {
/* 125 */       JOptionPane.showConfirmDialog(null, "更新完成", "下载提示", 0);
/* 126 */       System.exit(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\util\DownloadTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */