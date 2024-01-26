package com.example.XiaoLiuqiu.vo;

public class CarSearchReq {
	private String carId;
	private int carTypeId;
	private String carIntroduce;
	public CarSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarSearchReq(String carId, int carTypeId, String carIntroduce) {
		super();
		this.carId = carId;
		this.carTypeId = carTypeId;
		this.carIntroduce = carIntroduce;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public int getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
	}
	public String getCarIntroduce() {
		return carIntroduce;
	}
	public void setCarIntroduce(String carIntroduce) {
		this.carIntroduce = carIntroduce;
	}

	
}
