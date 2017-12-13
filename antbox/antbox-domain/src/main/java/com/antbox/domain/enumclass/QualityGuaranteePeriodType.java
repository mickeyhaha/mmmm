/*    */ package com.antbox.domain.enumclass;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum QualityGuaranteePeriodType
/*    */ {
/* 12 */   DAY(Integer.valueOf(0), "日"),  MONTH(Integer.valueOf(1), "月");
/*    */   
/*    */   public String text;
/*    */   public Integer code;
/*    */   
/*    */   private QualityGuaranteePeriodType(Integer code, String text) {
/* 18 */     this.text = text;
/* 19 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Date calculateExpiredTime(Date productionDate, int period) {
/* 23 */     Calendar calendar = Calendar.getInstance();
/* 24 */     calendar.setTime(productionDate);
/* 25 */     if (this.code == DAY.code)
/* 26 */       calendar.add(5, period);
/* 27 */     if (this.code == MONTH.code)
/* 28 */       calendar.add(2, period);
/* 29 */     return calendar.getTime();
/*    */   }
/*    */ }


/* Location:              D:\antbox-domain-1.0.0.jar!\com\antbox\domain\enumclass\QualityGuaranteePeriodType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */