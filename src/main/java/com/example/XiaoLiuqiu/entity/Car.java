package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@Column(name = "car_id")
	private String carId;
	
	@Column(name = "car_type_id")
	private int carTypeId;
	
	@Column(name = "car_introduce")
	private String carIntroduce;

	public Car() {
		super();
	}

	public Car(String carId, int carTypeId, String carIntroduce) {
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
