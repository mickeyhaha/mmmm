/*     */ package com.antbox.rfidmachine.client;
/*     */ 
/*     */ import com.antbox.rfidmachine.dto.AntboxRequest;
/*     */ import com.antbox.rfidmachine.dto.AntboxResponse;
/*     */ import com.antbox.rfidmachine.helper.AntboxrHelper;
/*     */ import com.antbox.rfidmachine.service.AntBoxService;
/*     */ import com.antbox.rfidmachine.util.AntboxUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import jssc.SerialPort;
/*     */ import jssc.SerialPortEvent;
/*     */ import jssc.SerialPortEventListener;
/*     */ import jssc.SerialPortException;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AntboxClient
/*     */   implements AntBoxService, SerialPortEventListener
/*     */ {
/*  32 */   private final Logger log = LoggerFactory.getLogger(AntboxClient.class);
/*     */   
/*     */ 
/*     */ 
/*     */   private String selectMachine;
/*     */   
/*     */ 
/*     */ 
/*  40 */   private volatile boolean opened = false;
/*     */   
/*     */ 
/*     */   private final String commAddress;
/*     */   
/*     */   private final SerialPort serialPort;
/*     */   
/*  47 */   private volatile short currentCommand = 255;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  52 */   private volatile short currentCommandState = 255;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */   private volatile List<AntboxResponse> result = Collections.synchronizedList(new LinkedList());
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  63 */   private final ByteBuf serialBuffer = Unpooled.buffer(30);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  68 */   private final ReentrantLock readerLock = new ReentrantLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  73 */   private final Condition resultReady = this.readerLock.newCondition();
/*     */   
/*     */   public AntboxClient(String commAddress)
/*     */   {
/*  77 */     this.commAddress = commAddress;
/*  78 */     this.serialPort = new SerialPort(commAddress);
/*  79 */     open();
/*     */   }
/*     */   
/*     */   public synchronized boolean isOpened() {
/*  83 */     return this.opened;
/*     */   }
/*     */   
/*     */   public synchronized void close()
/*     */   {
/*     */     try {
/*  89 */       this.serialPort.closePort();
/*  90 */       this.opened = false;
/*     */     } catch (SerialPortException ex) {
/*  92 */       if (this.log.isErrorEnabled()) {
/*  93 */         this.log.error("[" + this.commAddress + "] 关闭串口失败: " + ex.getClass().getSimpleName() + ": " + ex
/*  94 */           .getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void open()
/*     */   {
/*     */     try
/*     */     {
/* 103 */       this.serialPort.openPort();
/* 104 */       this.serialPort.setParams(19200, 8, 1, 0);
/*     */       
/*     */ 
/* 107 */       this.serialPort.setEventsMask(1);
/* 108 */       this.serialPort.addEventListener(this);
/* 109 */       this.opened = true;
/*     */     } catch (SerialPortException ex) {
/* 111 */       if (this.log.isErrorEnabled()) {
/* 112 */         this.log.error("[" + this.commAddress + "] 打开串口失败: " + ex.getClass().getSimpleName() + ": " + ex
/* 113 */           .getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInventoryTimeSeconds(int seconds)
/*     */   {
/* 120 */     ByteBuf data = Unpooled.buffer(1);
/* 121 */     data.writeByte(0xFF & 10 * seconds);
/* 122 */     sendCommand((short)4, (short)240, data);
/*     */     
/* 124 */     resetCommandAndResult();
/*     */   }
/*     */   
/*     */   public synchronized List<String> inventory(String selectMachine)
/*     */   {
/* 129 */     this.selectMachine = selectMachine;
/* 130 */     short scanCommand = 134;
/* 131 */     if ("OLD_MACHINE_MODEL".equals(selectMachine)) {
/* 132 */       scanCommand = 6;
/*     */     }
/* 134 */     sendCommand((short)1, scanCommand, null);
/* 135 */     List<AntboxResponse> rspList = new ArrayList();
/* 136 */     if (!this.result.isEmpty()) {
/* 137 */       rspList = AntboxrHelper.SINGLETON.getResult(AntboxResponse.class, this.result, this.currentCommand, this.currentCommandState);
/*     */     } else {
/* 139 */       this.log.info("读写器没有返回结果");
/*     */     }
/* 141 */     List<String> uidList = new LinkedList();
/* 142 */     for (AntboxResponse rsp : rspList) {
/* 143 */       if (StringUtils.isEmpty(rsp.getUid())) {
/*     */         break;
/*     */       }
/* 146 */       uidList.add(rsp.getUid());
/*     */     }
/* 148 */     return uidList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendCommand(short command, short state, ByteBuf data)
/*     */   {
/* 156 */     if (!tryLockReader()) {
/* 157 */       this.log.info("锁定读写器:读写器通讯超时");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 162 */       Thread.sleep(10L);
/*     */     } catch (InterruptedException e) {
/* 164 */       this.log.error("[" + this.commAddress + "] 发送命令失败: " + e.getClass().getSimpleName() + ": " + e
/* 165 */         .getMessage());
/*     */     }
/*     */     
/* 168 */     this.currentCommand = command;
/* 169 */     this.currentCommandState = state;
/* 170 */     AntboxRequest cmd = new AntboxRequest(command, state, data);
/* 171 */     if (this.log.isInfoEnabled()) {
/* 172 */       this.log.info("[" + this.commAddress + AntboxrHelper.SINGLETON.cmdStr(this.currentCommand, this.currentCommandState) + "] sendCommand: " + cmd);
/*     */     }
/*     */     try
/*     */     {
/* 176 */       this.serialPort.writeBytes(cmd.toByteBuf().array());
/*     */       
/* 178 */       if (!awaitResult()) {
/* 179 */         this.log.info("等待结果:读写器通讯超时");
/*     */       }
/*     */     } catch (SerialPortException ex) {
/* 182 */       if (this.log.isErrorEnabled()) {
/* 183 */         this.log.error("[" + this.commAddress + "] 发送命令失败: " + ex.getClass().getSimpleName() + ": " + ex
/* 184 */           .getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void serialEvent(SerialPortEvent event) {
/* 190 */     if (this.log.isInfoEnabled()) {
/* 191 */       this.log.info("[" + this.commAddress + "] SerialPortEvent: " + event.getEventType());
/*     */     }
/*     */     
/* 194 */     if ((!event.isRXCHAR()) || (event.getEventValue() <= 0)) {
/* 195 */       return;
/*     */     }
/*     */     
/*     */ 
/* 199 */     if (!this.readerLock.isHeldByCurrentThread()) {
/* 200 */       this.readerLock.lock();
/*     */     }
/*     */     try
/*     */     {
/* 204 */       byte[] buffer = this.serialPort.readBytes(event.getEventValue());
/* 205 */       this.serialBuffer.writeBytes(buffer);
/*     */       
/*     */       for (;;)
/*     */       {
/* 209 */         byte[] bodyLen0 = new byte[1];
/* 210 */         this.serialBuffer.getBytes(this.serialBuffer.readerIndex(), bodyLen0, 0, bodyLen0.length);
/* 211 */         int bodyLen = new BigInteger(1, bodyLen0).intValue();
/* 212 */         int frameLen = bodyLen + 1;
/* 213 */         if (this.serialBuffer.readableBytes() < frameLen) {
/*     */           break;
/*     */         }
/*     */         
/* 217 */         ByteBuf buf = this.serialBuffer.readBytes(frameLen);
/*     */         
/* 219 */         this.serialBuffer.discardReadBytes();
/* 220 */         AntboxResponse rsp = (AntboxResponse)new AntboxResponse(this.selectMachine).parse(buf);
/* 221 */         if (this.log.isInfoEnabled()) {
/* 222 */           this.log.info("[" + this.commAddress + AntboxrHelper.SINGLETON.cmdStr(this.currentCommand, this.currentCommandState) + "] 收到数据: " + 
/* 223 */             AntboxUtil.hexDump(buf.array()));
/*     */         }
/* 225 */         if (addToResult(rsp)) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     } catch (SerialPortException ex) {
/* 230 */       if (this.log.isErrorEnabled()) {
/* 231 */         this.log.error("[" + this.commAddress + "] " + ex.getClass().getSimpleName() + ": " + ex
/* 232 */           .getMessage());
/*     */       }
/* 234 */       resultReady();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void resetCommandAndResult()
/*     */   {
/* 242 */     this.currentCommand = 255;
/* 243 */     this.currentCommandState = 255;
/* 244 */     this.result.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean tryLockReader()
/*     */   {
/*     */     try
/*     */     {
/* 253 */       return this.readerLock.tryLock(6000L, TimeUnit.SECONDS);
/*     */     }
/*     */     catch (InterruptedException localInterruptedException) {}
/* 256 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean awaitResult()
/*     */   {
/*     */     try
/*     */     {
/* 265 */       return this.resultReady.await(6L, TimeUnit.SECONDS);
/*     */     }
/*     */     catch (InterruptedException localInterruptedException) {}
/*     */     
/* 269 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void resultReady()
/*     */   {
/* 276 */     this.resultReady.signal();
/* 277 */     this.readerLock.unlock();
/* 278 */     this.serialBuffer.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean addToResult(AntboxResponse rsp)
/*     */   {
/* 287 */     this.result.add(rsp);
/* 288 */     if (!AntboxrHelper.SINGLETON.isInventoryCommand(this.currentCommand, this.currentCommandState)) {
/* 289 */       resultReady();
/* 290 */       return true;
/*     */     }
/* 292 */     if ((14 == rsp.getStatus()) || (10 == rsp.getStatus())) {
/* 293 */       resultReady();
/* 294 */       return true;
/*     */     }
/* 296 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\client\AntboxClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */