/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ import com.antbox.domain.RfidProduct;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RfidProductDto
/*    */   extends RfidProduct
/*    */ {
/*    */   private List<String> rfidList;
/*    */   private String productName;
/*    */   private String batchNo;
/*    */   
/*    */   public List<String> getRfidList()
/*    */   {
/* 19 */     return this.rfidList;
/*    */   }
/*    */   
/*    */   public void setRfidList(List<String> rfidList) {
/* 23 */     this.rfidList = rfidList;
/*    */   }
/*    */   
/*    */   public String getProductName() {
/* 27 */     return this.productName;
/*    */   }
/*    */   
/*    */   public void setProductName(String productName) {
/* 31 */     this.productName = productName;
/*    */   }
/*    */   
/*    */   public String getBatchNo() {
/* 35 */     return this.batchNo;
/*    */   }
/*    */   
/*    */   public void setBatchNo(String batchNo) {
/* 39 */     this.batchNo = batchNo;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\RfidProductDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */