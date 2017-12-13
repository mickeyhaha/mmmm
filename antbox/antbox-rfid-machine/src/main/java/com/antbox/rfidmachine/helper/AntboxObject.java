/*     */ package com.antbox.rfidmachine.helper;
/*     */ 
/*     */ import com.antbox.rfidmachine.util.AntboxUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.ByteBufUtil;
/*     */ import io.netty.buffer.Unpooled;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AntboxObject
/*     */ {
/*  68 */   public int UID_BYTES_NUM = 9;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int UID_RADIX = 16;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int LENGTH_FIELD_OFFSET = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int LENGTH_FIELD_LENGTH = 1;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final byte DEFAULT_ADDR = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int NO_CRC = -1;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int CRC_LENGTH = 2;
/*     */   
/*     */ 
/*     */ 
/*     */   private int bodyLen;
/*     */   
/*     */ 
/*  99 */   private short addr = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private short command;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected short status;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private ByteBuf data;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   private int crc = -1;
/*     */   
/*     */ 
/*     */   public AntboxObject() {}
/*     */   
/*     */   public AntboxObject(short command, ByteBuf data)
/*     */   {
/* 128 */     this.command = command;
/* 129 */     this.data = data;
/*     */   }
/*     */   
/*     */ 
/*     */   protected abstract boolean hasCommand();
/*     */   
/*     */ 
/*     */   public short getStatus()
/*     */   {
/* 138 */     return this.status;
/*     */   }
/*     */   
/*     */   private int bodyLen() {
/* 142 */     if (this.bodyLen == 0) {
/* 143 */       this.bodyLen = (bufLen() - 1);
/*     */     }
/* 145 */     return this.bodyLen;
/*     */   }
/*     */   
/* 148 */   private int bufLen = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   private int bufLen()
/*     */   {
/* 154 */     if (this.bufLen > 0) {
/* 155 */       return this.bufLen;
/*     */     }
/*     */     
/*     */ 
/* 159 */     int n = 5;
/* 160 */     if (hasCommand()) {
/* 161 */       n++;
/*     */     }
/* 163 */     if (getData() != null) {
/* 164 */       n += getData().readableBytes();
/*     */     }
/* 166 */     this.bufLen = n;
/* 167 */     return this.bufLen;
/*     */   }
/*     */   
/*     */   public short getAddr() {
/* 171 */     return this.addr;
/*     */   }
/*     */   
/*     */   public short getCommand() {
/* 175 */     return this.command;
/*     */   }
/*     */   
/*     */   private ByteBuf getData() {
/* 179 */     if (this.data == null) {
/* 180 */       this.data = createData();
/*     */     }
/* 182 */     return this.data;
/*     */   }
/*     */   
/*     */   protected ByteBuf createData() {
/* 186 */     return null;
/*     */   }
/*     */   
/*     */   public void setData(ByteBuf data) {
/* 190 */     this.data = data;
/*     */   }
/*     */   
/*     */   public int getCrc() {
/* 194 */     return this.crc;
/*     */   }
/*     */   
/*     */   public ByteBuf toByteBuf() {
/* 198 */     ByteBuf buf = toByteBufWithoutCrc();
/* 199 */     this.crc = AntboxUtil.calcCrc(buf, 0);
/* 200 */     buf.writeShort(this.crc);
/* 201 */     return buf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private ByteBuf toByteBufWithoutCrc()
/*     */   {
/* 208 */     ByteBuf buf = Unpooled.buffer(bufLen() + 1);
/* 209 */     writeToWithoutCrc(buf);
/* 210 */     return buf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void writeToWithoutCrc(ByteBuf out)
/*     */   {
/* 217 */     out.writeByte(bodyLen());
/* 218 */     out.writeByte(this.addr);
/* 219 */     if (hasCommand()) {
/* 220 */       out.writeByte(this.command);
/*     */     }
/* 222 */     out.writeByte(this.status);
/*     */     
/* 224 */     if (getData() != null) {
/* 225 */       out.writeBytes(getData().duplicate());
/*     */     }
/*     */   }
/*     */   
/*     */   public AntboxObject parse(ByteBuf buf)
/*     */   {
/* 231 */     this.bodyLen = buf.readUnsignedByte();
/* 232 */     this.addr = buf.readUnsignedByte();
/* 233 */     if (hasCommand()) {
/* 234 */       this.command = buf.readUnsignedByte();
/*     */     }
/* 236 */     this.status = buf.readUnsignedByte();
/* 237 */     int dataLen = buf.readableBytes() - 2;
/* 238 */     if (dataLen > 0) {
/* 239 */       ByteBuf d = Unpooled.buffer(dataLen);
/* 240 */       buf.readBytes(d, dataLen);
/* 241 */       setData(d);
/*     */     } else {
/* 243 */       setData(Unpooled.EMPTY_BUFFER);
/*     */     }
/* 245 */     this.crc = buf.readUnsignedShort();
/* 246 */     return this;
/*     */   }
/*     */   
/*     */   public void copyFrom(AntboxObject src) {
/* 250 */     this.bodyLen = src.bodyLen();
/* 251 */     this.addr = src.getAddr();
/* 252 */     this.command = src.getCommand();
/* 253 */     this.status = src.getStatus();
/* 254 */     copyDataFrom(src);
/* 255 */     this.crc = src.getCrc();
/*     */   }
/*     */   
/*     */   private void copyDataFrom(AntboxObject src) {
/* 259 */     if (src.getData() != null) {
/* 260 */       setData(src.getData().duplicate());
/*     */     }
/*     */   }
/*     */   
/*     */   public <T extends AntboxObject> T castTo(Class<T> targetType)
/*     */   {
/* 266 */     if (targetType.equals(getClass())) {
/* 267 */       return this;
/*     */     }
/*     */     try {
/* 270 */       AntboxObject obj = (AntboxObject)targetType.newInstance();
/* 271 */       obj.copyFrom(this);
/* 272 */       return obj;
/*     */     } catch (Exception ex) {
/* 274 */       throw new RuntimeException(ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 280 */     StringBuilder b = new StringBuilder();
/* 281 */     b.append(getClass().getSimpleName()).append("[");
/* 282 */     b.append("bodyLen=").append(bodyLen()).append(", ");
/* 283 */     b.append("addr=").append(getAddr()).append(", ");
/* 284 */     b.append("command=0x").append(Integer.toHexString(getCommand())).append(", ");
/* 285 */     b.append("data=").append(stringOfData()).append(", ");
/* 286 */     b.append("crc=0x").append(Integer.toHexString(getCrc())).append(", ");
/* 287 */     b.append("status=0x").append(Integer.toHexString(getStatus())).append("]");
/* 288 */     return b.toString();
/*     */   }
/*     */   
/*     */   protected String stringOfData() {
/* 292 */     if (this.data == null) {
/* 293 */       return "";
/*     */     }
/*     */     
/* 296 */     return "0x" + ByteBufUtil.hexDump(this.data);
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\helper\AntboxObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */