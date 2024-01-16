package com.example.XiaoLiuqiu.constants;

public enum RtnCode {

	SUCCESSFUL(200,"Successful!!"),//
	PARAM_ERROR(400,"Param error"),//
	ACCOUNT_EXISTED(400,"Account existed!!"),//
	ACCOUNT_NOT_FOUND(404,"Account not found!!"),//
	MEMBER_NOT_FOUMD(400,"Member not foumd"),//
	PWD_NOT_FOUMD(400,"Pwd not foumd"),
	PWD_IS_EMPTY(400,"Pwd is empty"),
	PWD_ERROR(400,"Pwd error"),//
	NEW_PWD_ERROR(400,"New pwd error"),//
	DATE_FORMAT_ERROR(400,"Date format error"),//
	ORDER_CREATE_ERROR(400,"Order create error"),//
	ACCESS_IS_NOT_ALLOWED(400, "Access is not allowed"),//
	PLEASE_LOGIN_FIRST(400,"Please logon first"),//
	Room_ID_IS_EXISTED(400,"RoomId is existed!!"),
	;
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
