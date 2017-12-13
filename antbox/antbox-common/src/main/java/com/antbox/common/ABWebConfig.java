/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import com.fasterxml.jackson.annotation.PropertyAccessor;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import com.fasterxml.jackson.databind.SerializationFeature;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.List;
/*    */ import org.springframework.http.converter.FormHttpMessageConverter;
/*    */ import org.springframework.http.converter.HttpMessageConverter;
/*    */ import org.springframework.http.converter.StringHttpMessageConverter;
/*    */ import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
/*    */ import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ABWebConfig
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
/*    */   {
/* 24 */     super.configureMessageConverters(converters);
/* 25 */     Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
/* 26 */     builder.serializerByType(Long.class, new CustomLongConverter());
/* 27 */     builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
/* 28 */     ObjectMapper objectMapper = new ObjectMapper();
/* 29 */     objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
/* 30 */     objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
/* 31 */     builder.configure(objectMapper);
/*    */     
/*    */ 
/* 34 */     builder.serializationInclusion(JsonInclude.Include.NON_NULL);
/*    */     
/* 36 */     MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(builder.build());
/* 37 */     converters.add(mappingJackson2HttpMessageConverter);
/* 38 */     converters.add(new StringHttpMessageConverter());
/* 39 */     converters.add(new FormHttpMessageConverter());
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\ABWebConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */