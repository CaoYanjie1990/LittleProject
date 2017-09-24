package com.lz.bin;

public class User {
	private String userName;
	private String psw;
	
	public User(){}

	public User(String userName, String psw) {
		super();
		this.userName = userName;
		this.psw = psw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	

}
