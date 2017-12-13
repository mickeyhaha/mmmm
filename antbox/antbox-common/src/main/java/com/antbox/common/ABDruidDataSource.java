/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.alibaba.druid.pool.DruidDataSource;
/*    */ 
/*    */ 
/*    */ public class ABDruidDataSource
/*    */   extends DruidDataSource
/*    */ {
/*    */   public ABDruidDataSource(String url, String username, String password)
/*    */   {
/* 11 */     setMaxActive(100);
/* 12 */     setUrl(url);
/* 13 */     setUsername(username);
/* 14 */     setPassword(password);
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\ABDruidDataSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */