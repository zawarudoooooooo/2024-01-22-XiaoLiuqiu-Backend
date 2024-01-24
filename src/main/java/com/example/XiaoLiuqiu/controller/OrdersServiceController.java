package com.example.XiaoLiuqiu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersReq;
import com.example.XiaoLiuqiu.vo.OrdersRes;
import com.example.XiaoLiuqiu.vo.OrdersRoomSearchReq;
import com.example.XiaoLiuqiu.vo.OrdersSearchReq;

@CrossOrigin
@RestController
public class OrdersServiceController {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping(value = "order/ordersCreate")
	public OrdersRes ordersCreate(@RequestBody OrdersReq req) {
		return ordersService.ordersCreate(req.getMemberName(), req.getRoomId(), req.getOrderItem(), 
				req.getStartDate(), req.getEndDate(),req.isOrderPayment(),req.isPayOrNot());
		
	}
	
	
	
	@PostMapping(value = "order/search")
	public OrdersRes search(@RequestBody OrdersSearchReq req) {
		return ordersService.search(req.getRoomName(),req.getStartDate(), req.getEndDate());
	}
	
	@PostMapping(value = "order/searchMemberName")
	public OrdersRes searchMemberName(@RequestParam String memberName) {
		return ordersService.searchMemberName(memberName);
	}
	

}
