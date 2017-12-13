/*    */ package com.antbox.common;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.dao.IncorrectResultSizeDataAccessException;
/*    */ import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
/*    */ import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class QueryForObject<T>
/*    */ {
/*    */   @Autowired
/*    */   private NamedParameterJdbcTemplate jdbcTemplate;
/*    */   
/*    */   public T queryForObject(String sql, MapSqlParameterSource params, RBeanPropertyRowMapper<T> rBeanPropertyRowMapper)
/*    */   {
/*    */     try
/*    */     {
/* 21 */       return (T)this.jdbcTemplate.queryForObject(sql, params, rBeanPropertyRowMapper);
/*    */     }
/*    */     catch (Exception ex) {
/* 24 */       if (((ex instanceof IncorrectResultSizeDataAccessException)) && 
/* 25 */         (((IncorrectResultSizeDataAccessException)ex).getActualSize() == 0)) {
/* 26 */         return null;
/*    */       }
/* 28 */       throw new DaoException(ex.getMessage());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\QueryForObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */