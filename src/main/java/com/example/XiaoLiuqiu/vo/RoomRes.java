package com.example.XiaoLiuqiu.vo;

import com.example.XiaoLiuqiu.constants.RtnCode;

public class RoomRes {
	
	private RtnCode rtnCode;

	public RoomRes() {
		super();
	}

	public RoomRes(RtnCode rtncode) {
		super();
		this.rtnCode = rtncode;
	}

	public RtnCode getRtncode() {
		return rtnCode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtnCode = rtncode;
	}

}
