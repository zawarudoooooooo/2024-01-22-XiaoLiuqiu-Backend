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
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Column(name = "room_img")
	private String roomImg;

	public Room() {
		super();
	}

	
	
	



	public Room(String roomIntroduce, String roomName, int roomPrice, boolean isOpen, String roomImg) {
		super();
		this.roomIntroduce = roomIntroduce;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.isOpen = isOpen;
		this.roomImg = roomImg;
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

}
