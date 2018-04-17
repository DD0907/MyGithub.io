package com.entranceGuard.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JackJsonUtils {
	static ObjectMapper objectMapper;

	/**
	 * 解析JSON
	 * 
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> T fromJson(String content, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成JSON
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
