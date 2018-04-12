package com.blog.json;

import java.util.HashMap;
import java.util.Map;

public class StatusObject<T> {
	// result 判断是否成功 true&flase
	private String result;
	// message 返回信息
	private String message;
	
	private T data;
	
	private Map<String, Object> map = new HashMap<>();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(String key,Object value) {
		this.map.put(key, value);
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "StatusObject [result=" + result + ", message=" + message + "]";
	}
	public StatusObject(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
 }
