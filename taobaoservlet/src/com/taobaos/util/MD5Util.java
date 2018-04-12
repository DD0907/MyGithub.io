package com.taobaos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String getMd5(String plainText) {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(plainText.getBytes());
			byte b[] = mDigest.digest();
			int i;
			StringBuffer buffer = new StringBuffer();
			for (int j = 0; j < b.length; j++) {
				i = b[j];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buffer.append("0");
				}
				buffer.append(Integer.toHexString(i));
			}
			// 32为加密
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
