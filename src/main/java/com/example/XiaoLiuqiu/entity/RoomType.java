package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_type")
public class RoomType {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "room_type_id")
	private int roomTypeId;
	
	@Column(name = "room_type_name")
	private String roomTypeName;
	
	@Column(name = "room_type_price")
	private String roomTypePrice;

	public RoomType() {
		super();
	}

	public RoomType(int roomTypeId, String roomTypeName, String roomTypePrice) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomTypePrice = roomTypePrice;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomTypePrice() {
		return roomTypePrice;
	}

	public void setRoomTypePrice(String roomTypePrice) {
		this.roomTypePrice = roomTypePrice;
	}
	
	
}
