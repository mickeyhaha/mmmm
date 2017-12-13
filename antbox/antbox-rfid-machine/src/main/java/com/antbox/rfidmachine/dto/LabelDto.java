/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ 
/*    */ public class LabelDto
/*    */ {
/*    */   private int num;
/*    */   
/*    */   private String icon;
/*    */   
/*    */   private String tag;
/*    */   
/*    */   private String productName;
/*    */   
/*    */ 
/*    */   public LabelDto() {}
/*    */   
/*    */ 
/*    */   public LabelDto(int num, String icon, String tag, String productName)
/*    */   {
/* 20 */     this.num = num;
/* 21 */     this.icon = icon;
/* 22 */     this.tag = tag;
/* 23 */     this.productName = productName;
/*    */   }
/*    */   
/*    */   public int getNum() {
/* 27 */     return this.num;
/*    */   }
/*    */   
/*    */   public void setNum(int num) {
/* 31 */     this.num = num;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 35 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 39 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public String getTag() {
/* 43 */     return this.tag;
/*    */   }
/*    */   
/*    */   public void setTag(String tag) {
/* 47 */     this.tag = tag;
/*    */   }
/*    */   
/*    */   public String getProductName() {
/* 51 */     return this.productName;
/*    */   }
/*    */   
/*    */   public void setProductName(String productName) {
/* 55 */     this.productName = productName;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\LabelDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */