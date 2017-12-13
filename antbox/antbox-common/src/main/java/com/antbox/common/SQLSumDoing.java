/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public abstract interface SQLSumDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public List<String> go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper)
/*    */   {
/* 20 */     StringBuffer sql = new StringBuffer();
/* 21 */     StringBuffer fields = new StringBuffer();
/* 22 */     Map<String, Object> params = new HashMap();
/* 23 */     List<String> object = new ArrayList();
/*    */     
/* 25 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try {
/* 27 */       service(sql, fields, params, typeReferenceMap);
/*    */       
/* 29 */       String dataSql = sql.toString();
/* 30 */       if (fields.length() >= 1) {
/* 31 */         dataSql = String.format(sql.toString(), new Object[] { fields });
/*    */       }
/* 33 */       showSql(params, "dataSql", dataSql, log);
/* 34 */       List<String> sumFieldList = jdbcTemplate.queryForList(dataSql, params, String.class);
/* 35 */       object = sumFieldList;
/*    */     } catch (Exception e) {
/* 37 */       showErrorLog(e, log);
/*    */     }
/* 39 */     return object;
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1);
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLSumDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */