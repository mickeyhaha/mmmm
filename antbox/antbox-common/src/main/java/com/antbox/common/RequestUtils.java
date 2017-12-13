/*    */ package com.antbox.common;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.web.bind.ServletRequestUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RequestUtils
/*    */   extends ServletRequestUtils
/*    */ {
/*    */   public static String getIp(HttpServletRequest request)
/*    */   {
/* 13 */     String ip = request.getHeader("X-Forwarded-For");
/* 14 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 15 */       ip = request.getHeader("Proxy-Client-IP");
/*    */     }
/* 17 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 18 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 20 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 21 */       ip = request.getHeader("HTTP_CLIENT_IP");
/*    */     }
/* 23 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 24 */       ip = request.getHeader("HTTP_X_FORWARDED_FOR");
/*    */     }
/* 26 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 27 */       ip = request.getRemoteAddr();
/*    */     }
/* 29 */     return ip;
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RequestUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */