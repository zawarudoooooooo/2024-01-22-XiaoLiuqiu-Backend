package com.example.XiaoLiuqiu.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersRes;

@CrossOrigin
@RestController
public class OrdersServiceController {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping(value = "order/search")
	public OrdersRes search(String roomId, LocalDate startDate, LocalDate endDate) {
		return ordersService.search(roomId, startDate, endDate);
	}

}
