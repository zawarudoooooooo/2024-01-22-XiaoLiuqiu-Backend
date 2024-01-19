package com.example.XiaoLiuqiu.vo;

import com.example.XiaoLiuqiu.constants.RtnCode;

public class MemberResetPwdRes {
	
	private RtnCode rtnCode;

	public MemberResetPwdRes() {
		super();
	}

	public MemberResetPwdRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
}
