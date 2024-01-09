package com.example.XiaoLiuqiu.vo;

public class RoomRes {
	
	private int rtnCode;
	
	private String message;

	public RoomRes() {
		super();
	}

	public RoomRes(int rtnCode, String message) {
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
