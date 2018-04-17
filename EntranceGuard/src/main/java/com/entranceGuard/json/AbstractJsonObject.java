package com.entranceGuard.json;

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

	public void setResultObject(ResultObject<?> resultObject) {
		this.result = resultObject.getResult();
		this.message = resultObject.getMessage();
	}

	@Override
	public String toString() {
		return "AbstractJsonObject [result=" + result + ", message=" + message + "]";
	}
}
