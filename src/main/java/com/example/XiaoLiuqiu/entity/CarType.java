package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_type")
public class CarType {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "car_type_id")
	private int CarTypeId;
	
	@Column(name = "car_type_name")
	private String carTypeName;
	
	@Column(name = "car_type_price")
	private int carTypePrice;

	public CarType() {
		super();
	}

	public CarType(int carTypeId, String carTypeName, int carTypePrice) {
		super();
		CarTypeId = carTypeId;
		this.carTypeName = carTypeName;
		this.carTypePrice = carTypePrice;
	}

	public int getCarTypeId() {
		return CarTypeId;
	}

	public void setCarTypeId(int carTypeId) {
		CarTypeId = carTypeId;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public int getCarTypePrice() {
		return carTypePrice;
	}

	public void setCarTypePrice(int carTypePrice) {
		this.carTypePrice = carTypePrice;
	}
	
	

}
