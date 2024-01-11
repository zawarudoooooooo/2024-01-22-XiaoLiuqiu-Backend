package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;
import java.util.List;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersReq {
	
	@JsonProperty(value = "member_id")
	private int memberID;
	
	@JsonProperty(value = "room_id")
	private List<Room> roomId;
	
	@JsonProperty(value = "order_item")
	private List<Extra> orderItem;
	
	@JsonProperty(value = "start_date")
	private LocalDate startDate;
	
	@JsonProperty(value = "end_date")
	private LocalDate endDate;

	public OrdersReq() {
		super();
	}

	public OrdersReq(int memberID, List<Room> roomId, List<Extra> orderItem, LocalDate startDate, LocalDate endDate) {
		super();
		this.memberID = memberID;
		this.roomId = roomId;
		this.orderItem = orderItem;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public List<Room> getRoomId() {
		return roomId;
	}

	public void setRoomId(List<Room> roomId) {
		this.roomId = roomId;
	}

	public List<Extra> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<Extra> orderItem) {
		this.orderItem = orderItem;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	

	

	
	

}
