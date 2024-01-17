package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeLoginReq {
	private String account;

	@JsonProperty(value = "password")
	private String pwd;

	public EmployeeLoginReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeLoginReq(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
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
	
	
}
