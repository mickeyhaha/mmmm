/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.io.IOException;
/*    */ import java.text.ParseException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.slf4j.Logger;
/*    */ import org.springframework.jdbc.IncorrectResultSetColumnCountException;
/*    */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*    */ import org.springframework.jdbc.core.RowMapper;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface SQLListDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public List<T> go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper)
/*    */   {
/* 25 */     List<T> result = new ArrayList();
/* 26 */     StringBuffer sql = new StringBuffer();
/* 27 */     StringBuffer fields = new StringBuffer();
/* 28 */     Map<String, Object> params = new HashMap();
/*    */     
/* 30 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try {
/* 32 */       service(sql, fields, params, typeReferenceMap);
/* 33 */       String dataSql = sql.toString();
/* 34 */       if (fields.length() >= 1) {
/* 35 */         dataSql = dataSql.replace("%s", fields);
/*    */       }
/* 37 */       showSql(params, "dataSql", dataSql, log);
/* 38 */       if ((clazz == Long.class) || (clazz == Double.class) || (clazz == Float.class) || (clazz == Integer.class)) {
/* 39 */         result = jdbcTemplate.queryForList(dataSql, params, clazz);
/*    */       } else {
/* 41 */         RowMapper rowMapper = new BeanPropertyRowMapper(clazz);
/* 42 */         if (typeReferenceMap.size() > 0) {
/* 43 */           rowMapper = new RBeanPropertyRowMapper(clazz, objectMapper, typeReferenceMap);
/*    */         }
/* 45 */         result = jdbcTemplate.query(dataSql, params, rowMapper);
/*    */       }
/*    */       
/*    */     }
/*    */     catch (IncorrectResultSetColumnCountException localIncorrectResultSetColumnCountException) {}catch (Exception e)
/*    */     {
/* 51 */       showErrorLog(e, log);
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<T> go(Class clazz, ObjectMapper objectMapper, NamedParameterJdbcTemplate jdbcTemplate, Logger log)
/*    */   {
/* 65 */     return go(clazz, jdbcTemplate, log, objectMapper);
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1)
/*    */     throws ParseException, IOException;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLListDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */