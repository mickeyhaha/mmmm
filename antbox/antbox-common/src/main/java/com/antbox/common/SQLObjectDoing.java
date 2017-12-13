/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.type.TypeReference;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.text.ParseException;
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
/*    */ public abstract interface SQLObjectDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   public T go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper)
/*    */   {
/* 23 */     StringBuffer sql = new StringBuffer();
/* 24 */     StringBuffer fields = new StringBuffer();
/* 25 */     Map<String, Object> params = new HashMap();
/* 26 */     T object = null;
/*    */     
/*    */ 
/* 29 */     Map<String, TypeReference> typeReferenceMap = new HashMap();
/*    */     try
/*    */     {
/* 32 */       service(sql, fields, params, typeReferenceMap);
/*    */       
/* 34 */       if (fields.length() <= 0) {
/* 35 */         fields.append("*");
/*    */       }
/* 37 */       String dataSql = sql.toString().replace("%s", fields);
/*    */       
/*    */ 
/*    */ 
/* 41 */       showSql(params, "dataSql", dataSql, log);
/*    */       
/*    */ 
/* 44 */       if ((clazz == Long.class) || (clazz == Double.class) || (clazz == Float.class) || (clazz == Integer.class)) {
/* 45 */         List<T> list = jdbcTemplate.queryForList(dataSql, params, clazz);
/* 46 */         object = (list != null) && (list.size() != 0) ? list.get(0) : null;
/*    */       }
/*    */       else
/*    */       {
/* 50 */         RowMapper rowMapper = new BeanPropertyRowMapper(clazz);
/* 51 */         if (typeReferenceMap.size() > 0) {
/* 52 */           rowMapper = new RBeanPropertyRowMapper(clazz, objectMapper, typeReferenceMap);
/*    */         }
/* 54 */         List<T> list = jdbcTemplate.query(dataSql, params, rowMapper);
/* 55 */         object = (list != null) && (list.size() != 0) ? list.get(0) : null;
/*    */       }
/*    */     }
/*    */     catch (IncorrectResultSetColumnCountException e) {
/* 59 */       showErrorLog(e, log);
/*    */     } catch (Exception e) {
/* 61 */       showErrorLog(e, log);
/*    */     }
/* 63 */     return object;
/*    */   }
/*    */   
/*    */   public abstract void service(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, Map<String, Object> paramMap, Map<String, TypeReference> paramMap1)
/*    */     throws ParseException;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\SQLObjectDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */