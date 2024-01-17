package com.example.XiaoLiuqiu.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.vo.OrdersRes;

public interface OrdersService {

	public OrdersRes search(String memberName, LocalDate startDate, LocalDate endDate);
	
	public OrdersRes ordersCreate(String memberName, List<Room> roomIdStr,List<Extra> orderItemStr, LocalDate startDate, LocalDate endDate);

}
