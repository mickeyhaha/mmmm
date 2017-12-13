/*    */ package com.antbox.rfidmachine.dto;
/*    */ 
/*    */ import com.antbox.domain.Resource;
/*    */ import java.util.List;
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
/*    */ public class ResourceDto
/*    */   extends Resource
/*    */ {
/*    */   private String title;
/*    */   private String key;
/*    */   private List<ResourceDto> children;
/*    */   
/*    */   public List<ResourceDto> getChildren()
/*    */   {
/* 25 */     return this.children;
/*    */   }
/*    */   
/*    */   public void setChildren(List<ResourceDto> children) {
/* 29 */     this.children = children;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 33 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 37 */     this.title = title;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 41 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 45 */     this.key = key;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\dto\ResourceDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */