package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeReq {

	private String account;

	@JsonProperty(value = "password")
	private String pwd;

	private boolean access;

	public EmployeeReq() {
		super();
	}

	public EmployeeReq(String account, String pwd, boolean access) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.access = access;
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

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

}
