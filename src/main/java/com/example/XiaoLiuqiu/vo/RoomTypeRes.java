package com.example.XiaoLiuqiu.vo;

public class RoomTypeRes {

	private int rtnCode;
	
	private String message;

	public RoomTypeRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomTypeRes(int rtnCode, String message) {
		super();
		this.rtnCode = rtnCode;
		this.message = message;
	}

	public int getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(int rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
