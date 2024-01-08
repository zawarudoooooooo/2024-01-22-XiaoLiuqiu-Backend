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
	
	@Column(name = "room_type_id")
	private int roomTypeId;
	
	@Column(name = "room_introduce")
	private String roomIntroduce;

	public Room() {
		super();
	}

	public Room(String roomId, int roomTypeId, String roomIntroduce) {
		super();
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.roomIntroduce = roomIntroduce;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomIntroduce() {
		return roomIntroduce;
	}

	public void setRoomIntroduce(String roomIntroduce) {
		this.roomIntroduce = roomIntroduce;
	}
	
	

}
