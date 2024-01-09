package com.example.XiaoLiuqiu.service.ifs;

import java.time.LocalDate;

import com.example.XiaoLiuqiu.vo.OrdersRes;

public interface OrdersService {

	public OrdersRes search(String roomId, LocalDate startDate, LocalDate endDate);

}
