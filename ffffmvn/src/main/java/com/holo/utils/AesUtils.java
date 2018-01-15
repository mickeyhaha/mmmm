package com.holo.utils;


import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * 敏感数据加解密工具类 AES 是一种可逆加密算法<br>
 * 对用户的敏感信息加密处理 对原始数据进行AES加密后再进行Base64编码转化<br>
 * 
 * @package com.p2p.common.util
 * @author
 * @since
 * 
 */
public abstract class AesUtils {

	/*
	 * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
	 */
	private static String sKey = "0a1b2c3d4e5f6g7h";
	private static String ivParameter = "abcdefg123456789";
	
	// 加密
	/**
	 * 加密
	 * @param sSrc 值
	 * @param keyName 加密key 默认为 defaultKey
	 * @param ivName 加密iv 默认为 defaultIv
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static final String encrypt(String sSrc,String keyName,String ivName)  {
		try{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		if (keyName==null) {
			keyName="defaultKey";
		}
		if (ivName==null) {
			ivName="defaultIv";
		}
		
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		return new sun.misc.BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// 解密
	/**
	 * 解密
	 * @param sSrc 值
	 * @param keyName 加密key 默认为 defaultKey
	 * @param ivName 加密iv 默认为 defaultIv
	 * @return
	 */
	public static final String decrypt(String sSrc,String keyName,String ivName){
		try{
			if (keyName==null) {
				keyName="defaultKey";
			}
			if (ivName==null) {
				ivName="defaultIv";
			}
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			@SuppressWarnings("restriction")
			byte[] encrypted1 = new sun.misc.BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 需要加密的字串 Ae8alBAZlq66IWLrUmgtcg==
		String cSrc = "1001.80";
		System.out.println(cSrc);
		// 加密
		long lStart = System.currentTimeMillis();
		String enString = AesUtils.encrypt(cSrc,null,null);
		System.out.println("加密后的字串是" + enString);

		long lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("加密耗时：" + lUseTime + "毫秒");
		// 解密
		lStart = System.currentTimeMillis();
		String DeString = AesUtils.decrypt("OF2RZv/LQeFcsFCUO4U4CQ==",null,null);
		System.out.println("解密后的字串是：" + DeString);
		lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("解密耗时：" + lUseTime + "毫秒");
	}


}
