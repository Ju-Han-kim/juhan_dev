package com.juhan.web.user.model;

import java.sql.Timestamp;

public class UserVO {
	
	private int userNo;
	private String userId;
	private String password;
	private String name;
	private Timestamp regDate;
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", regDate=" + regDate + "]";
	}
	
}
