package com.xbh.bos.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xbh
 * @date 2019年1月10日12:05:34
 * @Description
 */
public class Cipher {
	static public String getMd5Cipher(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest instance = MessageDigest.getInstance("MD5");
		byte[] digest = instance.digest(s.getBytes("UTF-8"));
		StringBuffer result = new StringBuffer();
		String hexString;
		for (int i = 0; i < digest.length; i++) {
			hexString = Integer.toHexString(digest[i] & 0xFF);
			if (hexString.length() == 1){
				hexString = "0" + hexString;
			}
			result.append(hexString);
		}

		return result.toString();
	}
}
