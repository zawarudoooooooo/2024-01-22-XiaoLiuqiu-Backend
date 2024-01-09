package com.example.XiaoLiuqiu.vo;

public class MemberPwdReq {
	
	private String pwd;
	
	private String newPwd;
	
	private String confirmPwd;

	public MemberPwdReq() {
		super();
	}

	public MemberPwdReq(String pwd, String newPwd, String confirmPwd) {
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
