package com.example.XiaoLiuqiu.vo;

public class CarSearchRes {
	private int code;
	private String mesage;
	public CarSearchRes() {
		super();
		
	}
	public CarSearchRes(int code, String mesage) {
		super();
		this.code = code;
		this.mesage = mesage;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
}
