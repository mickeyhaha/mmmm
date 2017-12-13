/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import com.fasterxml.jackson.databind.DeserializationFeature;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Utils
/*    */ {
/* 25 */   public static final ObjectMapper objectMapper = new ObjectMapper();
/* 26 */   static { objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/* 27 */     objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*    */     
/* 29 */     xmlMapper = new XmlMapper();
/* 30 */     xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
/*    */   }
/*    */   
/*    */   public static final XmlMapper xmlMapper;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */