/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.text.ParseException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface SQLPageNextIdDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public PageResultNextId<T> go(Class<T> clazz, ObjectMapper objectMapper, NamedParameterJdbcTemplate jdbcTemplate, Logger log)
/*    */   {
/* 20 */     PageResultNextId<T> outPage = new PageResultNextId();
/* 21 */     StringBuilder sql = new StringBuilder();
/* 22 */     StringBuilder fields = new StringBuilder();
/* 23 */     String countField = "count(1)";
/* 24 */     Map<String, Object> params = new HashMap();
/*    */     
/*    */ 
/* 27 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try {
/* 29 */       service(sql, fields, params, typeReferenceMap);
/*    */       
/* 31 */       if (fields.length() <= 0) {
/* 32 */         fields.append("*");
/*    */       }
/*    */       
/* 35 */       String countStrSql = sql.toString();
/* 36 */       if (countStrSql.indexOf("order by") > 0) {
/* 37 */         int position = countStrSql.indexOf("order by");
/* 38 */         countStrSql = countStrSql.substring(0, position);
/*    */       }
/*    */       
/* 41 */       String countSql = countStrSql.replace("%s", countField);
/* 42 */       String dataSql = " limit 50".replace("%s", fields);
/*    */       
/* 44 */       showSql(params, "countSql", countSql, log);
/* 45 */       Long count = (Long)jdbcTemplate.queryForObject(countSql, params, Long.class);
/* 46 */       if ((count != null) && (count.longValue() <= 0L)) {
/* 47 */         return outPage;
/*    */       }
/* 49 */       showSql(params, "dataSql", dataSql, log);
/*    */       
/* 51 */       RBeanPropertyRowMapper rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz);
/* 52 */       if (objectMapper != null) {
/* 53 */         rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz, objectMapper, typeReferenceMap);
/*    */       }
/*    */       
/* 56 */       Long totalCount = count;
/* 57 */       List<T> list = jdbcTemplate.query(dataSql, params, rBeanPropertyRowMapper);
/* 58 */       outPage = new PageResultNextId(totalCount, list);
/*    */     } catch (Exception e) {
/* 60 */       errorLog(log, e);
/*    */     }
/* 62 */     return outPage;
/*    */   }
/*    */   
/*    */   public PageResultNextId<T> go(Class<T> clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log) {
/* 66 */     return go(clazz, null, jdbcTemplate, log);
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1)
/*    */     throws ParseException;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLPageNextIdDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */