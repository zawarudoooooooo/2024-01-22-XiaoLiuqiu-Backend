package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@Column(name = "room_id")
	private String roomId;

	@Column(name = "room_introduce")
	private String roomIntroduce;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "room_price")
	private int roomPrice;

	public Room() {
		super();
	}

	

	public Room(String roomId, String roomIntroduce, String roomName, int roomPrice) {
		super();
		this.roomId = roomId;
		this.roomIntroduce = roomIntroduce;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
	}



	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomIntroduce() {
		return roomIntroduce;
	}

	public void setRoomIntroduce(String roomIntroduce) {
		this.roomIntroduce = roomIntroduce;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

}
