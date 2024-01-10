package com.example.XiaoLiuqiu.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.repository.OrdersDAO;
import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersGetRes;
import com.example.XiaoLiuqiu.vo.OrdersRes;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersDAO orderDao;

	@Override
	public OrdersRes search(String roomId, LocalDate startDate, LocalDate endDate) {
		roomId = !StringUtils.hasText(roomId) ? "" : roomId;
		startDate = startDate == null ? startDate = LocalDate.of(1970, 01, 01) : startDate;
		endDate = endDate == null ? endDate = LocalDate.of(2099, 12, 31) : endDate;
		List<Orders> res = orderDao.findByRoomIdContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(roomId, startDate, endDate);
		return new OrdersGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);

	}
	
	

}
