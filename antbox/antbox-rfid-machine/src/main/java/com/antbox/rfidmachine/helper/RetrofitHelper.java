/*    */ package com.antbox.rfidmachine.helper;
/*    */ 
/*    */ import com.antbox.rfidmachine.service.LocalService;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude.Include;
/*    */ import com.fasterxml.jackson.databind.DeserializationFeature;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.text.SimpleDateFormat;
/*    */ import retrofit2.Retrofit;
/*    */ import retrofit2.Retrofit.Builder;
/*    */ import retrofit2.converter.jackson.JacksonConverterFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RetrofitHelper
/*    */ {
/* 18 */   SINGLETON;
/*    */   
/*    */   private RetrofitHelper() {}
/*    */   
/*    */   public Retrofit getRetrofit() {
/* 23 */     ObjectMapper objectMapper = new ObjectMapper();
/* 24 */     objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/* 25 */     objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/* 26 */     objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
/*    */     
/*    */ 
/*    */ 
/* 30 */     Retrofit retrofit = new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create(objectMapper)).baseUrl("http://api.mayihezi.com").build();
/*    */     
/* 32 */     return retrofit;
/*    */   }
/*    */   
/*    */   private static LocalService localService;
/* 36 */   public static LocalService getLocalService() { if (localService == null) {
/* 37 */       synchronized (RetrofitHelper.class) {
/* 38 */         Retrofit retrofit = SINGLETON.getRetrofit();
/* 39 */         localService = (LocalService)retrofit.create(LocalService.class);
/*    */       }
/*    */     }
/* 42 */     return localService;
/*    */   }
/*    */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\helper\RetrofitHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */