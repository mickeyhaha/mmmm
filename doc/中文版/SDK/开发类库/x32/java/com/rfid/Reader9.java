package com.rfid;

public class Reader9 {
    
	public native int OpenComPort(int port,byte[]comAddr,byte baud,int[]PortHandle);
    public native int CloseSpecComPort(int PortHandle);
    public native int OpenNetPort(int Port,String IPaddr,byte[]comAddr,int[] PortHandle);
    public native int CloseNetPort(int PortHandle);
    public native int GetReaderInformation(byte[]comAddr,byte[]versionInfo,byte[]readerType,byte[]trType,byte[]InventoryScanTime,int PortHandle);
    public native int Inventory(byte[]comAddr,byte State,byte AFI,byte[]DsfidAndUID,int[] CardNum,int PortHandle);
    public native int ReadSingleBlock(byte[]comAddr,byte State,byte[] UID,byte BlockNum,byte[] BlockSecStatus,byte[]Data,byte[]errorCode,int PortHandle);
    public native int WriteSingleBlock(byte[]comAddr,byte State,byte[] UID,byte BlockNum,byte[]Data,byte[]errorCode,int PortHandle);
    public native int ReadMultipleBlock(byte[]comAddr,byte State,byte[] UID,byte BlockNum,byte blockCount,byte[] BlockSecStatus,byte[]Data,byte[]errorCode,int PortHandle);
    public native int LockBlock(byte[]comAddr,byte State,byte[] UID,byte BlockNum,byte[]errorCode,int PortHandle);
    public native int WriteAFI(byte[]comAddr,byte State,byte[] UID,byte AFI,byte[]errorCode,int PortHandle);
    public native int LockAFI(byte[]comAddr,byte State,byte[] UID,byte[]errorCode,int PortHandle);
    public native int WriteDSFID(byte[]comAddr,byte State,byte[] UID,byte DSFID,byte[]errorCode,int PortHandle);
    public native int LockDSFID(byte[]comAddr,byte State,byte[] UID,byte[]errorCode,int PortHandle);
    public native int GetSystemInformation(byte[]comAddr,byte State,byte[] UIDI,byte[]InformationFlag,byte[]UIDO,byte[]DSFID,byte[]AFI,byte[]MemorySize,byte[]ICReference,byte[]errorCode,int PortHandle);
    public native int OpenRf(byte[]comAddr,int PortHandle);
    public native int CloseRf(byte[]comAddr,int PortHandle);
    public native int WriteComAdr(byte[]comAddr,byte newComAddr,int PortHandle);
    public native int WriteInventoryScanTime(byte[]comAddr,byte InventoryScanTime,int PortHandle);
    public native int SetRelay(byte[]comAddr,byte _Relay,int PortHandle);
    public native int SetGeneralOutput(byte[]comAddr,byte _Output,int PortHandle);
    public native int GetGeneralInput(byte[]comAddr,byte[] _Input,int PortHandle);
    public native int SetActiveANT(byte[]comAddr,byte _ANT_Status,int PortHandle);
    public native int GetANTStatus(byte[]comAddr,byte[] Get_ANT_Status,int PortHandle);
    public native int SetScanMode(byte[]comAddr,byte[] _Scan_Mode_Data,int PortHandle);
    public native int GetScanModeStatus(byte[]comAddr,byte[] _Scan_Mode_Status,int PortHandle);
    public native int ReadScanModeData(byte[]ScanModeData,int[] ValidDatalength,int PortHandle);
    public native int TransparentRead(byte[]comAddr,byte RspLength,byte CustomDatalength,byte[]CustomData,byte[]FeedbackDataLength,byte[] FeedbackData,byte[]errorCode,int PortHandle);
    public native int TransparentWrite(byte[]comAddr,byte[]option,byte RspLength,byte CustomDatalength,byte[]CustomData,byte[]FeedbackDataLength,byte[] FeedbackData,byte[]errorCode,int PortHandle);
    public native int TransparentCustomizedCmd(byte[]comAddr,byte[]RspTime,byte RspLength,byte CustomDatalength,byte[]CustomData,byte[]FeedbackDataLength,byte[] FeedbackData,byte[]errorCode,int PortHandle);
    public native int SetParseMode(byte[]comAddr,byte _ParseMode,int PortHandle);
    public native int GetParseMode(byte[]comAddr,byte[] Get_ParseMode,int PortHandle);
    public native int SetEASAlarm(byte[]comAddr,byte state,byte[] UID,int PortHandle);
    public native int ReSetEAS(byte[]comAddr,byte state,byte[] UID,int PortHandle);
    public native int DetectEASAlarm(byte[]comAddr,byte state,byte[] UID,int PortHandle);
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
