/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GoodsDto
/*    */ {
/*    */   private Long id;
/*    */   
/*    */   private String name;
/*    */   
/*    */ 
/*    */   public GoodsDto() {}
/*    */   
/*    */ 
/*    */   public GoodsDto(Long id, String name)
/*    */   {
/* 17 */     this.id = id;
/* 18 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 26 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 30 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 34 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 39 */     return this.name;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\GoodsDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */