/*    */ package com.antbox.common;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PhoneValidator
/*    */ {
/*    */   public static boolean isValidatePhone(String phone)
/*    */   {
/* 12 */     if ((phone == null) || (phone.length() > 12)) {
/* 13 */       return false;
/*    */     }
/* 15 */     return (isMobliePhoneLegal(phone)) || (isCommonPhoneLegal(phone)) || (isServiceLegal(phone));
/*    */   }
/*    */   
/*    */   private static boolean isMobliePhoneLegal(String str) {
/* 19 */     String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(14[579]))\\d{8}$";
/* 20 */     Pattern p = Pattern.compile(regExp);
/* 21 */     Matcher m = p.matcher(str);
/* 22 */     return m.matches();
/*    */   }
/*    */   
/*    */   private static boolean isCommonPhoneLegal(String str) {
/* 26 */     String regExp = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$";
/* 27 */     Pattern p = Pattern.compile(regExp);
/* 28 */     Matcher m = p.matcher(str);
/* 29 */     return m.matches();
/*    */   }
/*    */   
/*    */   private static boolean isServiceLegal(String str) {
/* 33 */     String regExp = "^[48]00\\d{7}$";
/* 34 */     Pattern p = Pattern.compile(regExp);
/* 35 */     Matcher m = p.matcher(str);
/* 36 */     return m.matches();
/*    */   }
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\PhoneValidator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */