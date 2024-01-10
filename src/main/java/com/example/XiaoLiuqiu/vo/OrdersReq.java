package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersReq {
	
	@JsonProperty(value = "room_id")
	private String roomId;
	
	@JsonProperty(value = "order_item")
	private String orderItem;
	
	@JsonProperty(value = "start_date")
	private LocalDate startDate;
	
	@JsonProperty(value = "end_date")
	private LocalDate endDate;

	public OrdersReq() {
		super();
	}

	public OrdersReq(String roomId, String orderItem, LocalDate startDate, LocalDate endDate) {
		super();
		this.roomId = roomId;
		this.orderItem = orderItem;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
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
