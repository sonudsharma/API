package com.models;

public class ErrorObject {
	private String msg;
	private int errorCode;
	
	public ErrorObject() {
		super();
	}
	public ErrorObject(String msg, int errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
