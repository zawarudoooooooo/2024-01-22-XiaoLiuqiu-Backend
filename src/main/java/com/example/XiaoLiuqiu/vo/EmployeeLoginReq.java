package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeLoginReq {
	private String account;

	@JsonProperty(value = "password")
	private String pwd;
	
	private boolean resignation;

	public EmployeeLoginReq() {
		super();
	}

	public EmployeeLoginReq(String account, String pwd, boolean resignation) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.resignation = resignation;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isResignation() {
		return resignation;
	}

	public void setResignation(boolean resignation) {
		this.resignation = resignation;
	}

}
