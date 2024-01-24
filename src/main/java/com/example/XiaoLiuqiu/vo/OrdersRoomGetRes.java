package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.Orders;

public class OrdersRoomGetRes extends OrdersRes{
	
	private List<Orders> orderList;

	public OrdersRoomGetRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersRoomGetRes(int code, String message, List<Orders> orderList) {
		super(code, message);
		this.orderList = orderList;
		// TODO Auto-generated constructor stub
	}

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	
	

}
