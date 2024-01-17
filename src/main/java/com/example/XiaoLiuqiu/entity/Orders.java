package com.example.XiaoLiuqiu.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	@Column(name = "member_name")
	private String memberName;

	 @Column(name = "room_id")
	private String roomId;
	
	@Column(name = "order_item")
	private String orderItem;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "order_date_time")
	private LocalDateTime orderDateTime;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String memberName, String roomId, String orderItem, LocalDate startDate, LocalDate endDate,
			LocalDateTime orderDateTime) {
		super();
		this.memberName = memberName;
		this.roomId = roomId;
		this.orderItem = orderItem;
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderDateTime = orderDateTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	

	


	
	

	

	

}
