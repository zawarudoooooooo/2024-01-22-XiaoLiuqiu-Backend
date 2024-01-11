package com.example.XiaoLiuqiu.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
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
	}

	public Orders(int memberId, String roomId, String orderItem, LocalDate startDate, LocalDate endDate) {
		super();
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

	public String getRoomIdStr() {
		return roomId;
	}

	public void setRoomIdStr(String roomId) {
		this.roomId = roomId;
	}

	public String getOrderItemStr() {
		return orderItem;
	}

	public void setOrderItemStr(String orderItem) {
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
