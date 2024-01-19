package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberResetPwdReq {
	
	@JsonProperty(value = "new_password")
	private String newPwd;
	
	@JsonProperty(value = "confirm_password")
	private String confirmPwd;

	public MemberResetPwdReq() {
		super();
	}

	public MemberResetPwdReq(String newPwd, String confirmPwd) {
		super();
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
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
