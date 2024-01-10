package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.Orders;

public class OrdersGetRes extends OrdersRes{
	
	private List<Orders> orderList;

	public OrdersGetRes() {
		super();
	}

	public OrdersGetRes(int code, String message, List<Orders> orderList) {
		super(code, message);
		this.orderList = orderList;
	}

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}



	

}
