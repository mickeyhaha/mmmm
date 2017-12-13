/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.jdbc.IncorrectResultSetColumnCountException;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public abstract interface SQLUpdateDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public T go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper)
/*    */   {
/* 19 */     StringBuffer sql = new StringBuffer();
/* 20 */     StringBuffer fields = new StringBuffer();
/* 21 */     Map<String, Object> params = new HashMap();
/* 22 */     T object = null;
/*    */     
/*    */ 
/* 25 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try
/*    */     {
/* 28 */       service(sql, fields, params, typeReferenceMap);
/* 29 */       String dataSql = sql.toString();
/* 30 */       if (fields.length() >= 1) {
/* 31 */         dataSql = String.format(sql.toString(), new Object[] { fields });
/*    */       }
/* 33 */       showSql(params, "dataSql", dataSql, log);
/* 34 */       jdbcTemplate.update(dataSql, params);
/*    */     }
/*    */     catch (IncorrectResultSetColumnCountException localIncorrectResultSetColumnCountException) {}catch (Exception e)
/*    */     {
/* 38 */       showErrorLog(e, log);
/*    */     }
/* 40 */     return object;
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1);
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLUpdateDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */