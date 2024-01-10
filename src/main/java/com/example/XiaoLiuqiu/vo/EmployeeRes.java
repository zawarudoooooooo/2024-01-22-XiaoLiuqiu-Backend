package com.example.XiaoLiuqiu.vo;

import com.example.XiaoLiuqiu.constants.RtnCode;

public class EmployeeRes {
	
	private RtnCode rtnCode;

	public EmployeeRes() {
		super();
	}

	public EmployeeRes(RtnCode rtnCode) {
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
