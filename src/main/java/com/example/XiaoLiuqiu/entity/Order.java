package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "member_id")
	private int memberId;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "car_id")
	private String carId;
	
	@Column(name = "extra_id")
	private String extraId;

	public Order() {
		super();
	}

	public Order(int orderId, int memberId, String roomId, String carId, String extraId) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.roomId = roomId;
		this.carId = carId;
		this.extraId = extraId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getExtraId() {
		return extraId;
	}

	public void setExtraId(String extraId) {
		this.extraId = extraId;
	}
	
	

}
