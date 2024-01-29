package com.example.XiaoLiuqiu.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.vo.OrdersRes;

public interface OrdersService {

	public OrdersRes search(String roomName, LocalDate startDate, LocalDate endDate);
	
	public OrdersRes searchMemberName(String memberName);
	
	public OrdersRes ordersCreate(String memberName, String roomIdStr,List<Extra> orderItemStr, 
			LocalDate startDate, LocalDate endDate, boolean orderPayment ,boolean payOrNot,int total);
	
	public OrdersRes orderFinished(int orderId);

}
