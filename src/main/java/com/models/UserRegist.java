package com.models;

public class UserRegist {
	private int success;
	private String msg;
	private UserRegistrationDetails data;

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

	public UserRegistrationDetails getData() {
		return data;
	}

	public void setData(UserRegistrationDetails data) {
		this.data = data;
	}

}
