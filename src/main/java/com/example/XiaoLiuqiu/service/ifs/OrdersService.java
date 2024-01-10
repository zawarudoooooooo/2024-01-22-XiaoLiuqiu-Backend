package com.example.XiaoLiuqiu.service.ifs;

import java.time.LocalDate;

import com.example.XiaoLiuqiu.vo.OrdersRes;

public interface OrdersService {

	public OrdersRes search(String roomId, LocalDate startDate, LocalDate endDate);
	
	public OrdersRes ordersCreate(int memberId, String roomId,String orderItem, LocalDate startDate, LocalDate endDate);

}
