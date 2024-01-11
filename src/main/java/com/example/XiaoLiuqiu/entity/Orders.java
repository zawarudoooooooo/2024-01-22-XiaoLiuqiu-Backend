package com.example.XiaoLiuqiu.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_order")
public class Orders {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "member_id")
	private int memberId;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "order_item")
	private String orderItem;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, int memberId, String roomId, String orderItem, LocalDate startDate, LocalDate endDate) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.roomId = roomId;
		this.orderItem = orderItem;
		this.startDate = startDate;
		this.endDate = endDate;
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
