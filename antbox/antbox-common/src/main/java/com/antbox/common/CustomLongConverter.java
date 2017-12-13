/*    */ package com.antbox.common;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.databind.SerializerProvider;
/*    */ import com.fasterxml.jackson.databind.ser.std.StdSerializer;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class CustomLongConverter extends StdSerializer<Long>
/*    */ {
/*    */   public CustomLongConverter()
/*    */   {
/* 13 */     super(Long.class);
/*    */   }
/*    */   
/*    */   public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException
/*    */   {
/* 18 */     if (value.toString().length() > 12) {
/* 19 */       gen.writeString(value.toString());
/*    */     } else {
/* 21 */       gen.writeNumber(value.longValue());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\CustomLongConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */