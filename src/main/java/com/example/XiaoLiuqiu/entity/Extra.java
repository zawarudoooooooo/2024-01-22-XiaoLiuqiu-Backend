package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extra")
public class Extra {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "extra_id")
	private int extraId;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "extra_name")
	private String extraName;
	
	@Column(name = "extra_price")
	private String extraPrice;

	public Extra() {
		super();
	}

	public Extra(int extraId, String roomId, String extraName, String extraPrice) {
		super();
		this.extraId = extraId;
		this.roomId = roomId;
		this.extraName = extraName;
		this.extraPrice = extraPrice;
	}

	public int getExtraId() {
		return extraId;
	}

	public void setExtraId(int extraId) {
		this.extraId = extraId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getExtraName() {
		return extraName;
	}

	public void setExtraName(String extraName) {
		this.extraName = extraName;
	}

	public String getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(String extraPrice) {
		this.extraPrice = extraPrice;
	}

	
}
