package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersReq {
	
	private String memberName;
	
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

	public OrdersReq(String memberName, List<Room> roomId, List<Extra> orderItem, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.memberName = memberName;
		this.roomId = roomId;
		this.orderItem = orderItem;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
