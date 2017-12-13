/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.io.IOException;
/*    */ import java.text.ParseException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public abstract interface SQLPageDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public PageResult<T> go(PageRequest pageRequest, Class<T> clazz, ObjectMapper objectMapper, NamedParameterJdbcTemplate jdbcTemplate, String pageURl, String countField, Logger log)
/*    */   {
/* 23 */     PageResult<T> outPage = new PageResult();
/* 24 */     StringBuilder sql = new StringBuilder();
/* 25 */     StringBuilder fields = new StringBuilder();
/* 26 */     countField = countField == null ? "count(1)" : countField;
/* 27 */     Map<String, Object> params = new HashMap();
/* 28 */     if (null != params.get("groupBy")) {
/* 29 */       countField = params.get("groupBy").toString();
/*    */     }
/*    */     
/* 32 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try {
/* 34 */       service(sql, fields, params, typeReferenceMap);
/*    */       
/* 36 */       if (fields.length() <= 0) {
/* 37 */         fields.append("*");
/*    */       }
/*    */       
/* 40 */       String countStrSql = sql.toString();
/* 41 */       if (countStrSql.indexOf("group by") > 0) {
/* 42 */         int position = countStrSql.indexOf("group by");
/* 43 */         countStrSql = countStrSql.substring(0, position);
/* 44 */       } else if (countStrSql.indexOf("order by") > 0) {
/* 45 */         int position = countStrSql.indexOf("order by");
/* 46 */         countStrSql = countStrSql.substring(0, position);
/*    */       }
/*    */       
/* 49 */       String countSql = countStrSql.replace("%s", countField);
/* 50 */       String dataSql = " limit :offset,:size".replace("%s", fields);
/*    */       
/* 52 */       showSql(params, "countSql", countSql, log);
/* 53 */       Long count = (Long)jdbcTemplate.queryForObject(countSql, params, Long.class);
/* 54 */       if ((count != null) && (count.longValue() <= 0L)) {
/* 55 */         return outPage;
/*    */       }
/* 57 */       params.put("offset", Integer.valueOf(pageRequest.getOffset()));
/* 58 */       params.put("size", Integer.valueOf(pageRequest.getPageSize()));
/* 59 */       showSql(params, "dataSql", dataSql, log);
/*    */       
/* 61 */       RBeanPropertyRowMapper rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz);
/* 62 */       if (objectMapper != null) {
/* 63 */         rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz, objectMapper, typeReferenceMap);
/*    */       }
/*    */       
/* 66 */       Integer pageNo = Integer.valueOf(pageRequest.getPageNumber());
/* 67 */       Integer pageSize = Integer.valueOf(pageRequest.getPageSize());
/* 68 */       Long totalCount = count;
/* 69 */       long begin = System.currentTimeMillis();
/* 70 */       List<T> list = jdbcTemplate.query(dataSql, params, rBeanPropertyRowMapper);
/* 71 */       long end = System.currentTimeMillis();
/* 72 */       long queryTime = end - begin;
/* 73 */       log.info("go query time: {}", Long.valueOf(queryTime));
/* 74 */       outPage = new PageResult(pageNo, pageSize, totalCount, list, pageURl);
/*    */     } catch (Exception e) {
/* 76 */       errorLog(log, e);
/*    */     }
/* 78 */     return outPage;
/*    */   }
/*    */   
/*    */   public PageResult<T> go(PageRequest pageRequest, Class<T> clazz, NamedParameterJdbcTemplate jdbcTemplate, String pageURL, Logger log) {
/* 82 */     return go(pageRequest, clazz, null, jdbcTemplate, pageURL, null, log);
/*    */   }
/*    */   
/*    */   public PageResult<T> go(PageRequest pageRequest, Class<T> clazz, NamedParameterJdbcTemplate jdbcTemplate, String pageURL, String countField, Logger log) {
/* 86 */     return go(pageRequest, clazz, null, jdbcTemplate, pageURL, countField, log);
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1)
/*    */     throws ParseException, IOException;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLPageDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */