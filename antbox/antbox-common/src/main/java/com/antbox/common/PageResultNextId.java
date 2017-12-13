/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PageResultNextId<T>
/*    */   extends PageResult<T>
/*    */ {
/*    */   private Long nextId;
/*    */   
/*    */   public PageResultNextId() {}
/*    */   
/*    */   public PageResultNextId(Long totalCount, List<T> data)
/*    */   {
/* 17 */     this.pageSize = Integer.valueOf(50);
/* 18 */     this.pageNo = null;
/* 19 */     if (totalCount != null) {
/* 20 */       this.totalCount = Integer.valueOf(totalCount.intValue());
/*    */     }
/* 22 */     if (data != null) {
/* 23 */       this.list = data;
/*    */     }
/*    */   }
/*    */   
/*    */   public Long getNextId() {
/* 28 */     return this.nextId;
/*    */   }
/*    */   
/*    */   public void setNextId(Long nextId) {
/* 32 */     this.nextId = nextId;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\PageResultNextId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */