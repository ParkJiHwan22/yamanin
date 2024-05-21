package com.yamanin.model.dto;

public class UserLoginDto {
	private String loginId;
	private String password;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserLoginDto(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	public UserLoginDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserLoginDto [loginId=" + loginId + ", password=" + password + "]";
	}
	
	
}
