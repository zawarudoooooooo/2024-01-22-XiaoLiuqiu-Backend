package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.Orders;

public class OrdersGetRes extends OrdersRes{
	
	private List<RoomVo> orderList;

	public OrdersGetRes() {
		super();
	}

	public OrdersGetRes(int code, String message, List<RoomVo> orderList) {
		super(code, message);
		this.orderList = orderList;
	}

	public List<RoomVo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<RoomVo> orderList) {
		this.orderList = orderList;
	}



	

}
