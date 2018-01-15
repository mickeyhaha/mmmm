package com.holo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * @Description 艺车贷表单验证token 生成工具类
 * @author 刘小龙
 * @date 2017年6月8日 上午10:34:09
 * @version V1.3.1
 */
public class TokenProccessor {
	
	private TokenProccessor() {
		
	}
	private static final TokenProccessor instance = new TokenProccessor();
	
	public static String SESSION_TOKEN="token";

	/**
	 * 返回类的对象
	 */
	public static TokenProccessor getInstance() {
		return instance;
	}

	/**
	 * 生成Token Token：Nv6RRuGEVvmGjB+jimI/gw==
	 */
	public String makeToken() {
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
