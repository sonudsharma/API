package com.models;

public class JwtUser {
	private String userName;
	private long id;
	private String Expiration;
	// private String role;

	public String getExpiration() {
		return Expiration;
	}

	public void setExpiration(String expiration) {
		Expiration = expiration;
	}

	public JwtUser() {
		super();
	}

	public JwtUser(String userName, long id, String role) {
		super();
		this.userName = userName;
		this.id = id;
		// this.role = role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public void setRole(String role) { this.role = role; }
	 */

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}

	/*
	 * public String getRole() { return role; }
	 */

	@Override
	public String toString() {
		return "JwtUser [userName=" + userName + ", id=" + id + "]";
	}

}
