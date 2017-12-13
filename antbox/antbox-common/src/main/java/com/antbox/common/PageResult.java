/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.data.domain.Page;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties({"offset"})
/*    */ public class PageResult<T>
/*    */ {
/* 15 */   public List<T> list = new ArrayList();
/* 16 */   public Integer totalCount = Integer.valueOf(0);
/* 17 */   public Integer totalPage = Integer.valueOf(0);
/* 18 */   public Integer pageNo = Integer.valueOf(0);
/* 19 */   public Integer pageSize = Integer.valueOf(10);
/* 20 */   public Integer offset = Integer.valueOf(0);
/*    */   public String url;
/*    */   public String prevUrl;
/*    */   public String nextUrl;
/*    */   
/*    */   public PageResult() {}
/*    */   
/*    */   public PageResult(Page page, String pageUrl)
/*    */   {
/* 29 */     init(Integer.valueOf(page.getNumber()), Integer.valueOf(page.getSize()), Long.valueOf(page.getTotalElements()), page.getContent());
/* 30 */     setUrl(pageUrl);
/*    */   }
/*    */   
/*    */   public PageResult(Integer pageNo, Integer pageSize, Long totalCount, List<T> list, String pageUrl) {
/* 34 */     init(pageNo, pageSize, totalCount, list);
/* 35 */     setUrl(pageUrl);
/*    */   }
/*    */   
/*    */   public PageResult(Integer pageNo, Integer pageSize, Long totalCount, List<T> list) {
/* 39 */     init(pageNo, pageSize, totalCount, list);
/*    */   }
/*    */   
/*    */   public PageResult(Integer pageNo, Integer pageSize, Long totalCount) {
/* 43 */     this(pageNo, pageSize, totalCount, null);
/*    */   }
/*    */   
/*    */   public PageResult(Integer pageNo, Integer pageSize) {
/* 47 */     this(pageNo, pageSize, null);
/*    */   }
/*    */   
/*    */   public void init(Integer pageNo, Integer pageSize, Long totalCount, List<T> data) {
/* 51 */     if (pageNo != null) {
/* 52 */       this.pageNo = pageNo;
/*    */     }
/* 54 */     if (pageSize != null) {
/* 55 */       this.pageSize = pageSize;
/*    */     }
/* 57 */     if (this.pageNo.intValue() > 0) {
/* 58 */       this.offset = Integer.valueOf(this.pageSize.intValue() * this.pageNo.intValue());
/*    */     }
/* 60 */     if (totalCount != null) {
/* 61 */       this.totalCount = Integer.valueOf(totalCount.intValue());
/* 62 */       this.totalPage = Integer.valueOf(this.totalCount.intValue() % pageSize.intValue() > 0 ? this.totalCount.intValue() / pageSize.intValue() + 1 : this.totalCount.intValue() / pageSize.intValue());
/*    */     }
/* 64 */     if (data != null) {
/* 65 */       this.list = data;
/*    */     }
/*    */   }
/*    */   
/*    */   public void setUrl(String url)
/*    */   {
/* 71 */     this.url = url;
/* 72 */     setPrevUrl(url + "?pageNo=" + (this.pageNo.intValue() <= 0 ? 0 : (this.pageNo.intValue() > 0) && (this.pageNo.intValue() >= this.totalPage.intValue()) ? this.totalPage.intValue() - 1 : this.pageNo.intValue() - 1) + "&pageSize=" + this.pageSize);
/* 73 */     setNextUrl(url + "?pageNo=" + (this.pageNo.intValue() <= 0 ? 1 : (this.pageNo.intValue() > 0) && (this.pageNo.intValue() >= this.totalPage.intValue()) ? this.totalPage.intValue() - 1 : this.pageNo.intValue() + 1) + "&pageSize=" + this.pageSize);
/*    */   }
/*    */   
/*    */   public String getPrevUrl() {
/* 77 */     return this.prevUrl;
/*    */   }
/*    */   
/*    */   private void setPrevUrl(String prevUrl) {
/* 81 */     this.prevUrl = prevUrl;
/*    */   }
/*    */   
/*    */   public String getNextUrl() {
/* 85 */     return this.nextUrl;
/*    */   }
/*    */   
/*    */   private void setNextUrl(String nextUrl) {
/* 89 */     this.nextUrl = nextUrl;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\PageResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */