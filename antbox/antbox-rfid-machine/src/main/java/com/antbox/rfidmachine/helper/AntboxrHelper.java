/*     */ package com.antbox.rfidmachine.helper;
/*     */ 
/*     */ import com.antbox.common.RestResult;
/*     */ import com.antbox.rfidmachine.dto.AntboxResponse;
/*     */ import com.antbox.rfidmachine.dto.UserDto;
/*     */ import com.antbox.rfidmachine.enumclass.SystemType;
/*     */ import com.antbox.rfidmachine.service.LocalService;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import retrofit2.Call;
/*     */ import retrofit2.Response;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum AntboxrHelper
/*     */ {
/*  20 */   SINGLETON;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String NEW_MACHINE_MODEL = "RSSI_MACHINE_MODEL";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String OLD_MACHINE_MODEL = "OLD_MACHINE_MODEL";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short STATE_TYPE_ISO15693 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short STATE_READER_COMMAND = 240;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short STATE_NEW_INVENTORY_SCAN = 6;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short STATE_RSSI_INVENTORY_SCAN = 134;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short NO_COMMAND = 255;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short INVENTORY = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final short WRITE_INVENTORYSCANTIME = 4;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int ALL_UID_SCANNED = 14;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int NO_UID_SCANNED = 10;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int MAX_FRAME_LENGTH = 30;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private AntboxrHelper() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T extends AntboxObject> List<T> getResult(Class<T> targetType, List<AntboxResponse> result, short currentCommand, short currentCommandState)
/*     */   {
/*  93 */     List<T> targets = new LinkedList();
/*     */     
/*  95 */     for (AntboxResponse rsp : result) {
/*  96 */       short status = rsp.getStatus();
/*  97 */       if (0 == status) {
/*  98 */         targets.add(rsp.castTo(targetType));
/*  99 */       } else if (((14 == status) || (10 == status)) && 
/* 100 */         (isInventoryCommand(currentCommand, currentCommandState))) {
/* 101 */         targets.add(rsp.castTo(targetType));
/*     */       }
/*     */     }
/*     */     
/* 105 */     return targets;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isInventoryCommand(short currentCommand, short currentCommandState)
/*     */   {
/* 112 */     if (currentCommandState == 6) {
/* 113 */       return (1 == currentCommand) && (0 == (currentCommandState & 0xF0));
/*     */     }
/*     */     
/* 116 */     if (1 == currentCommand) {} return 0 == ((currentCommandState & 0xF0) > 0 ? 0 : 1);
/*     */   }
/*     */   
/*     */ 
/*     */   public String cmdStr(short currentCommand, short currentCommandState)
/*     */   {
/* 122 */     return 
/* 123 */       " cmd=0x" + Integer.toHexString(currentCommand).toUpperCase() + " state=0x" + Integer.toHexString(currentCommandState).toUpperCase();
/*     */   }
/*     */   
/*     */   public UserDto merchantLogin(UserDto dto, LocalService localService) throws Exception
/*     */   {
/* 128 */     dto.setSystemType(SystemType.MERCHANT);
/* 129 */     Response<RestResult<UserDto>> jsonResultResponse = localService.localLogin(dto).execute();
/* 130 */     String resultCode = ((RestResult)jsonResultResponse.body()).getCode();
/* 131 */     if (resultCode.equals(RestResult.CD1[0])) {
/* 132 */       UserDto user = (UserDto)((RestResult)jsonResultResponse.body()).data;
/* 133 */       if ((user != null) && (user.getAccessToken() != null)) {
/* 134 */         dto.setAccessToken(user.getAccessToken());
/*     */       }
/*     */     }
/* 137 */     return dto;
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\helper\AntboxrHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */