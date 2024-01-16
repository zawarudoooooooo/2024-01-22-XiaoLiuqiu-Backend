package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeUpdateReq {
	
	@JsonProperty(value = "password")
	private String pwd;
	
	@JsonProperty(value = "new_password")
	private String newPwd;
	
	@JsonProperty(value = "confirm_password")
	private String confirmPwd;

	public EmployeeUpdateReq() {
		super();
	}

	public EmployeeUpdateReq(String pwd, String newPwd, String confirmPwd) {
		super();
		this.pwd = pwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

}
