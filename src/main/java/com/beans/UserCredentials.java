package com.beans;

public class UserCredentials {
	private String userId;
	private String password;
	private String userType;
	private boolean loginStatus;
	
	
	
	public UserCredentials() {
		
	}

	public UserCredentials(String userId, String password, String userType, boolean loginStatus) {
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
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



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	public boolean getLoginStatus() {
		return loginStatus;
	}



	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}



	@Override
	public String toString() {
		return "<td>" + userId + "</td>"+
			   "<td>" + password + "</td>"+
			   "<td>" + loginStatus + "</td>";
	}
}
