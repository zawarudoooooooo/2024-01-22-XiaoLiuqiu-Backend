package com.example.XiaoLiuqiu.vo;

public class MemberUpDateReq {

	private String memberName;
	
	private String memberPhone;
	
	private String memberEmail;

	public MemberUpDateReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberUpDateReq(String memberName, String memberPhone, String memberEmail) {
		super();
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
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
