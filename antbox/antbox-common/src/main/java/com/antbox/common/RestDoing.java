/*    */ package com.antbox.common;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public abstract interface RestDoing<T>
/*    */   extends BaseDoing<T>
/*    */ {
/*    */   @Deprecated
/*    */   public RestResult<T> go(Logger log)
/*    */   {
/* 17 */     return invoke(null, null, null, log);
/*    */   }
/*    */   
/*    */   public RestResult<T> go(HttpServletRequest r, Logger log) {
/* 21 */     return invoke(null, null, r, log);
/*    */   }
/*    */   
/*    */   public RestResult<T> go(Object inputData, Logger log) {
/* 25 */     return invoke(inputData, null, null, log);
/*    */   }
/*    */   
/*    */   public RestResult<T> go(Object visitor, HttpServletRequest request, Logger log) {
/* 29 */     return invoke(null, visitor, request, log);
/*    */   }
/*    */   
/*    */   public RestResult<T> go(Object inputData, Object visitor, HttpServletRequest request, Logger log) {
/* 33 */     return invoke(inputData, visitor, request, log);
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public RestResult<T> invoke(Object inputData, Object visitor, HttpServletRequest request, Logger log)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   3: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   6: astore 5
/*    */     //   8: aload_3
/*    */     //   9: ifnull +32 -> 41
/*    */     //   12: aload 4
/*    */     //   14: ldc 4
/*    */     //   16: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   19: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   22: iconst_3
/*    */     //   23: aaload
/*    */     //   24: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   27: aload_3
/*    */     //   28: invokeinterface 8 1 0
/*    */     //   33: invokeinterface 9 4 0
/*    */     //   38: goto +23 -> 61
/*    */     //   41: aload 4
/*    */     //   43: ldc 10
/*    */     //   45: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   48: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   51: iconst_3
/*    */     //   52: aaload
/*    */     //   53: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   56: invokeinterface 11 3 0
/*    */     //   61: new 12	com/antbox/common/RestResult
/*    */     //   64: dup
/*    */     //   65: invokespecial 13	com/antbox/common/RestResult:<init>	()V
/*    */     //   68: astore 6
/*    */     //   70: aload_0
/*    */     //   71: aload_2
/*    */     //   72: getstatic 14	com/antbox/common/Utils:objectMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
/*    */     //   75: aload 4
/*    */     //   77: invokeinterface 15 4 0
/*    */     //   82: aload_0
/*    */     //   83: aload_3
/*    */     //   84: aload 4
/*    */     //   86: invokeinterface 16 3 0
/*    */     //   91: aload_0
/*    */     //   92: aload_1
/*    */     //   93: getstatic 14	com/antbox/common/Utils:objectMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
/*    */     //   96: aload 4
/*    */     //   98: invokeinterface 17 4 0
/*    */     //   103: aload_0
/*    */     //   104: aload 6
/*    */     //   106: invokeinterface 18 2 0
/*    */     //   111: aload_0
/*    */     //   112: aload 6
/*    */     //   114: getstatic 14	com/antbox/common/Utils:objectMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
/*    */     //   117: aload 4
/*    */     //   119: invokeinterface 19 4 0
/*    */     //   124: aload_3
/*    */     //   125: ifnull +57 -> 182
/*    */     //   128: aload 4
/*    */     //   130: ldc 20
/*    */     //   132: iconst_3
/*    */     //   133: anewarray 21	java/lang/Object
/*    */     //   136: dup
/*    */     //   137: iconst_0
/*    */     //   138: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   141: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   144: iconst_3
/*    */     //   145: aaload
/*    */     //   146: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   149: aastore
/*    */     //   150: dup
/*    */     //   151: iconst_1
/*    */     //   152: aload_3
/*    */     //   153: invokeinterface 8 1 0
/*    */     //   158: aastore
/*    */     //   159: dup
/*    */     //   160: iconst_2
/*    */     //   161: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   164: aload 5
/*    */     //   166: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   169: lsub
/*    */     //   170: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   173: aastore
/*    */     //   174: invokeinterface 23 3 0
/*    */     //   179: goto +339 -> 518
/*    */     //   182: aload 4
/*    */     //   184: ldc 24
/*    */     //   186: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   189: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   192: iconst_3
/*    */     //   193: aaload
/*    */     //   194: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   197: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   200: aload 5
/*    */     //   202: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   205: lsub
/*    */     //   206: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   209: invokeinterface 9 4 0
/*    */     //   214: goto +304 -> 518
/*    */     //   217: astore 7
/*    */     //   219: aload 7
/*    */     //   221: instanceof 26
/*    */     //   224: ifeq +21 -> 245
/*    */     //   227: aload_0
/*    */     //   228: aload 4
/*    */     //   230: aload 7
/*    */     //   232: checkcast 26	com/antbox/common/CheckException
/*    */     //   235: aload 6
/*    */     //   237: invokeinterface 27 4 0
/*    */     //   242: goto +49 -> 291
/*    */     //   245: aload 7
/*    */     //   247: instanceof 28
/*    */     //   250: ifeq +21 -> 271
/*    */     //   253: aload_0
/*    */     //   254: aload 4
/*    */     //   256: aload 7
/*    */     //   258: checkcast 28	com/antbox/common/RemindException
/*    */     //   261: aload 6
/*    */     //   263: invokeinterface 29 4 0
/*    */     //   268: goto +23 -> 291
/*    */     //   271: aload 7
/*    */     //   273: instanceof 25
/*    */     //   276: ifeq +15 -> 291
/*    */     //   279: aload_0
/*    */     //   280: aload 4
/*    */     //   282: aload 7
/*    */     //   284: aload 6
/*    */     //   286: invokeinterface 30 4 0
/*    */     //   291: invokestatic 31	org/springframework/transaction/interceptor/TransactionAspectSupport:currentTransactionStatus	()Lorg/springframework/transaction/TransactionStatus;
/*    */     //   294: invokeinterface 32 1 0
/*    */     //   299: goto +5 -> 304
/*    */     //   302: astore 8
/*    */     //   304: aload_0
/*    */     //   305: aload 6
/*    */     //   307: getstatic 14	com/antbox/common/Utils:objectMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
/*    */     //   310: aload 4
/*    */     //   312: invokeinterface 19 4 0
/*    */     //   317: aload_3
/*    */     //   318: ifnull +57 -> 375
/*    */     //   321: aload 4
/*    */     //   323: ldc 20
/*    */     //   325: iconst_3
/*    */     //   326: anewarray 21	java/lang/Object
/*    */     //   329: dup
/*    */     //   330: iconst_0
/*    */     //   331: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   334: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   337: iconst_3
/*    */     //   338: aaload
/*    */     //   339: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   342: aastore
/*    */     //   343: dup
/*    */     //   344: iconst_1
/*    */     //   345: aload_3
/*    */     //   346: invokeinterface 8 1 0
/*    */     //   351: aastore
/*    */     //   352: dup
/*    */     //   353: iconst_2
/*    */     //   354: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   357: aload 5
/*    */     //   359: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   362: lsub
/*    */     //   363: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   366: aastore
/*    */     //   367: invokeinterface 23 3 0
/*    */     //   372: goto +146 -> 518
/*    */     //   375: aload 4
/*    */     //   377: ldc 24
/*    */     //   379: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   382: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   385: iconst_3
/*    */     //   386: aaload
/*    */     //   387: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   390: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   393: aload 5
/*    */     //   395: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   398: lsub
/*    */     //   399: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   402: invokeinterface 9 4 0
/*    */     //   407: goto +111 -> 518
/*    */     //   410: astore 9
/*    */     //   412: aload_0
/*    */     //   413: aload 6
/*    */     //   415: getstatic 14	com/antbox/common/Utils:objectMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
/*    */     //   418: aload 4
/*    */     //   420: invokeinterface 19 4 0
/*    */     //   425: aload_3
/*    */     //   426: ifnull +57 -> 483
/*    */     //   429: aload 4
/*    */     //   431: ldc 20
/*    */     //   433: iconst_3
/*    */     //   434: anewarray 21	java/lang/Object
/*    */     //   437: dup
/*    */     //   438: iconst_0
/*    */     //   439: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   442: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   445: iconst_3
/*    */     //   446: aaload
/*    */     //   447: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   450: aastore
/*    */     //   451: dup
/*    */     //   452: iconst_1
/*    */     //   453: aload_3
/*    */     //   454: invokeinterface 8 1 0
/*    */     //   459: aastore
/*    */     //   460: dup
/*    */     //   461: iconst_2
/*    */     //   462: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   465: aload 5
/*    */     //   467: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   470: lsub
/*    */     //   471: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   474: aastore
/*    */     //   475: invokeinterface 23 3 0
/*    */     //   480: goto +35 -> 515
/*    */     //   483: aload 4
/*    */     //   485: ldc 24
/*    */     //   487: invokestatic 5	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*    */     //   490: invokevirtual 6	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*    */     //   493: iconst_3
/*    */     //   494: aaload
/*    */     //   495: invokevirtual 7	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
/*    */     //   498: invokestatic 2	java/lang/System:currentTimeMillis	()J
/*    */     //   501: aload 5
/*    */     //   503: invokevirtual 22	java/lang/Long:longValue	()J
/*    */     //   506: lsub
/*    */     //   507: invokestatic 3	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*    */     //   510: invokeinterface 9 4 0
/*    */     //   515: aload 9
/*    */     //   517: athrow
/*    */     //   518: aload 6
/*    */     //   520: areturn
/*    */     // Line number table:
/*    */     //   Java source line #37	-> byte code offset #0
/*    */     //   Java source line #39	-> byte code offset #8
/*    */     //   Java source line #40	-> byte code offset #12
/*    */     //   Java source line #42	-> byte code offset #41
/*    */     //   Java source line #45	-> byte code offset #61
/*    */     //   Java source line #47	-> byte code offset #70
/*    */     //   Java source line #48	-> byte code offset #82
/*    */     //   Java source line #49	-> byte code offset #91
/*    */     //   Java source line #50	-> byte code offset #103
/*    */     //   Java source line #65	-> byte code offset #111
/*    */     //   Java source line #66	-> byte code offset #124
/*    */     //   Java source line #67	-> byte code offset #128
/*    */     //   Java source line #69	-> byte code offset #182
/*    */     //   Java source line #73	-> byte code offset #214
/*    */     //   Java source line #51	-> byte code offset #217
/*    */     //   Java source line #52	-> byte code offset #219
/*    */     //   Java source line #53	-> byte code offset #227
/*    */     //   Java source line #54	-> byte code offset #245
/*    */     //   Java source line #55	-> byte code offset #253
/*    */     //   Java source line #56	-> byte code offset #271
/*    */     //   Java source line #57	-> byte code offset #279
/*    */     //   Java source line #60	-> byte code offset #291
/*    */     //   Java source line #62	-> byte code offset #299
/*    */     //   Java source line #61	-> byte code offset #302
/*    */     //   Java source line #65	-> byte code offset #304
/*    */     //   Java source line #66	-> byte code offset #317
/*    */     //   Java source line #67	-> byte code offset #321
/*    */     //   Java source line #69	-> byte code offset #375
/*    */     //   Java source line #73	-> byte code offset #407
/*    */     //   Java source line #65	-> byte code offset #410
/*    */     //   Java source line #66	-> byte code offset #425
/*    */     //   Java source line #67	-> byte code offset #429
/*    */     //   Java source line #69	-> byte code offset #483
/*    */     //   Java source line #74	-> byte code offset #518
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	521	0	this	RestDoing<T>
/*    */     //   0	521	1	inputData	Object
/*    */     //   0	521	2	visitor	Object
/*    */     //   0	521	3	request	HttpServletRequest
/*    */     //   0	521	4	log	Logger
/*    */     //   6	496	5	startTime	Long
/*    */     //   68	451	6	jr	RestResult<T>
/*    */     //   217	66	7	ex	Exception
/*    */     //   302	1	8	localNoTransactionException	org.springframework.transaction.NoTransactionException
/*    */     //   410	106	9	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   70	111	217	java/lang/Exception
/*    */     //   291	299	302	org/springframework/transaction/NoTransactionException
/*    */     //   70	111	410	finally
/*    */     //   217	304	410	finally
/*    */     //   410	412	410	finally
/*    */   }
/*    */   
/*    */   public abstract void service(RestResult<T> paramRestResult)
/*    */     throws Exception;
/*    */ }


/* Location:              D:\antbox-common-1.0.0.jar!\com\antbox\common\RestDoing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */