package test;
import com.rfid.Reader9.*;
public class Device {
	 public static void main(String[] args) {
	        // TODO code application logic here
		    System.loadLibrary("com_rfid_Reader9");
		    com.rfid.Reader9 rd = new com.rfid.Reader9();
		    int Port = 1;//com1
		    byte[]comAddr=new byte[1];
		    comAddr[0]=(byte)255;
		    byte baud=0;//19200bps
		    int[] PortHandle= new int[1];
		    //��������
		    int result = rd.OpenComPort(1, comAddr, baud, PortHandle);
		    System.out.println("���Ӵ��ڣ�"+ result);
		    
		    /////////TCP����
		    /*int result = rd.OpenNetPort(6800, "192.168.3.11", comAddr, PortHandle);
		    System.out.println(result);
		    result = rd.CloseNetPort(PortHandle[0]);
		    System.out.println(result);*/

		    //��ȡ��д����Ϣ
		    byte[]versionInfo=new byte[2];
		    byte[]readerType=new byte[1];
		    byte[]trType=new byte[2];
		    byte[]InventoryScanTime=new byte[1];
		    result = rd.GetReaderInformation(comAddr, versionInfo, readerType, trType, InventoryScanTime, PortHandle[0]);
		    System.out.println("��ȡ��д����Ϣ��"+result);
		    
		   	//ѯ���ǩInventory
		    byte[]DsfidAndUID=new byte[5000];
		    int[]CardNum=new int[1];
		    byte state=6;
		    byte afi=0;
		    CardNum[0]=0;
		    result = rd.Inventory(comAddr, state, afi, DsfidAndUID, CardNum, PortHandle[0]);
		    System.out.println("ѯ������:"+result);
		    if(CardNum[0]>0)
		    {
		    	for(int m=0;m<CardNum[0];m++)
		    	{
		    		byte[]UID = new byte[8];
		    		System.arraycopy(DsfidAndUID, m*9+1, UID, 0, 8);
		    		String struid="";
		    		for(int n=0;n<8;n++)
		    		{
		    			String hex= Integer.toHexString(UID[n]& 255);
		    			if(hex.length()==1)
		    			{
		    				hex="0"+hex;
		    			}
		    			struid+=hex;
		    		}
		    		System.out.println("UID�ţ�"+struid);
		    		///////д��0������
		    		byte State=8;
		    		byte BlockNum=0;//����0��
		    		byte[]Data=new byte[256];
		    		Data[0]=0x12;
		    		Data[1]=0x34;
		    		Data[2]=0x56;
		    		Data[3]=0x78;
		    		byte[]errorCode=new byte[1];
		    		result = rd.WriteSingleBlock(comAddr, State, UID, BlockNum, Data, errorCode, PortHandle[0]);
		    		System.out.println("д��0����:"+result);
		    		
		    		///////����0������
		    		State=0;
		    		byte[]BlockSecStatus=new byte[27];
		    		result = rd.ReadSingleBlock(comAddr, State, UID, BlockNum, BlockSecStatus, Data, errorCode, PortHandle[0]);
		    		System.out.println("������:"+result);
		    		if(result==0)
		    		{
		    			String str="";
			    		for(int n=0;n<4;n++)
			    		{
			    			String hex= Integer.toHexString(Data[n]& 255);
			    			if(hex.length()==1)
			    			{
			    				hex="0"+hex;
			    			}
			    			str+=hex;
			    		}
			    		System.out.println("��0����:"+str);
		    		}
		    		
		    		
		    		///////��0-27������
		    		byte blockCount=28;
		    		result = rd.ReadMultipleBlock(comAddr, State, UID, BlockNum, blockCount, BlockSecStatus, Data, errorCode, PortHandle[0]);
		    		System.out.println("�����:"+result);
		    		if(result==0)
		    		{
		    			String sdata ="";
		    			for(int p=0;p<blockCount*4;p++)
		    			{
		    				String hex= Integer.toHexString(Data[p]& 255);
			    			if(hex.length()==1)
			    			{
			    				hex="0"+hex;
			    			}
			    			sdata+=hex;
		    			}
		    			System.out.println("0-27������:"+sdata);
		    		}
		    	}
		    }
		    result = rd.CloseSpecComPort(PortHandle[0]);
		    System.out.println(result);
	    }
}
