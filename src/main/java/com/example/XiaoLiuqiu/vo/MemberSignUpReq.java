package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberSignUpReq {

	
	private String account;
	
	@JsonProperty("password")
	private String pwd;
	
	private String memberName;
	
	private String memberPhone;
	
	private String memberEmail;
	
	

	public MemberSignUpReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberSignUpReq(String account, String pwd, String memberName, String memberPhone, String memberEmail) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
}
