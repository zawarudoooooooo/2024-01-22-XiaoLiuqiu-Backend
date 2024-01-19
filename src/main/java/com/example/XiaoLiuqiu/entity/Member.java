package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "member_id")
	private int memberId;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_phone")
	private String memberPhone;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	@Column(name = "rest_code")
	private String restCode;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "verified")
	private boolean verified;

	@Column(name = "member_photo")
	private String memberPhoto;
	public Member() {
		super();
	}

	public Member(String account, String pwd, String memberName, String memberPhone, String memberEmail, boolean verified, String memberPhoto) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.verified = verified;
		this.memberPhoto = memberPhoto;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	public String getRestCode() {
		return restCode;
	}

	public void setRestCode(String restCode) {
		this.restCode = restCode;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	
}
