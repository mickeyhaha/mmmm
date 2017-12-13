/*    */ package com.antbox.rfidmachine.swing;
/*    */ 
/*    */ import com.antbox.rfidmachine.util.DownloadTask;
/*    */ import java.awt.Container;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DownloadJarTable
/*    */   extends JFrame
/*    */   implements PropertyChangeListener
/*    */ {
/*    */   private JProgressBar progressBar;
/*    */   
/*    */   public DownloadJarTable(String newDependJar, String oldDependJar)
/*    */   {
/* 21 */     setTitle("欢迎下载 - 蚂蚁盒子一体机客户端");
/* 22 */     init(newDependJar, oldDependJar);
/* 23 */     setBounds(0, 0, 350, 200);
/* 24 */     setDefaultCloseOperation(3);
/* 25 */     setLayout(null);
/* 26 */     setVisible(true);
/* 27 */     setResizable(false);
/* 28 */     setLocationRelativeTo(null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void init(String newDependJar, String oldDependJar)
/*    */   {
/* 35 */     this.progressBar = new JProgressBar();
/* 36 */     this.progressBar.setStringPainted(true);
/* 37 */     this.progressBar.setMinimum(0);
/* 38 */     this.progressBar.setMaximum(100);
/* 39 */     this.progressBar.setBounds(30, 80, 290, 10);
/* 40 */     getContentPane().add(this.progressBar);
/*    */     
/*    */     try
/*    */     {
/* 44 */       this.progressBar.setValue(0);
/* 45 */       DownloadTask task = new DownloadTask(this, newDependJar, oldDependJar);
/* 46 */       task.addPropertyChangeListener(this);
/* 47 */       task.execute();
/*    */     } catch (Exception ex) {
/* 49 */       JOptionPane.showMessageDialog(this, "更新出错: " + ex.getMessage(), "Error", 0);
/*    */     }
/*    */   }
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
/*    */   public void propertyChange(PropertyChangeEvent evt)
/*    */   {
/* 72 */     if (evt.getPropertyName().equals("progress")) {
/* 73 */       int progress = ((Integer)evt.getNewValue()).intValue();
/* 74 */       this.progressBar.setValue(progress);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\swing\DownloadJarTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */