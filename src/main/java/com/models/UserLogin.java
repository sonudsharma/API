package com.models;

public class UserLogin {
	private int success;
	private String msg;
	private UserLoginDetails data = new UserLoginDetails();
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public UserLoginDetails getData() {
		return data;
	}
	public void setData(UserLoginDetails data) {
		this.data = data;
	}
	
	
}
