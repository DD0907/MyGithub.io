package com.blog.json;

public class AbstractJsonObject {
	private String result;
	private String message;

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

	public void setContent(String result, String message) {
		this.result = result;
		this.message = message;
	}

	public void setStatusObject(StatusObject<?> statusObject) {
		this.result = statusObject.getResult();
		this.message = statusObject.getMessage();
	}

	@Override
	public String toString() {
		return "AbstractJsonObject [result=" + result + ", message=" + message + "]";
	}
}
