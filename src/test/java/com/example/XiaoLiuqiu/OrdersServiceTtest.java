package com.example.XiaoLiuqiu;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.repository.OrdersDAO;
import com.example.XiaoLiuqiu.repository.RoomDAO;
import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersRes;
import com.example.XiaoLiuqiu.vo.RoomVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class OrdersServiceTtest {

	
	@Autowired
	public OrdersService ordersService;
	
	@Autowired
	private OrdersDAO orderDao;
	
	@Autowired
	private RoomDAO roomDao;
	
//	@Test
//	public void orderTest1() {
//		List<Extra> order=Arrays.asList(
//				new Extra("早餐",200),
//				new Extra("門票",500)
//				);
//		OrdersRes res=ordersService.ordersCreate("Roy", "A02" , order, 
//				LocalDate.now(), LocalDate.now().plusDays(1),true,false);
//		System.out.println(res.getCode()+res.getMessage());
//	}
//	
//	@Test
//	public void orderTest2() {
//		List<Extra> order=Arrays.asList(
//				new Extra("[早餐,摩托車]",1000)
//				);
//		OrdersRes res=ordersService.ordersCreate("王曉明", "A02" , order, 
//				LocalDate.now(), LocalDate.now().plusDays(1),true,false);
//		System.out.println(res.getCode()+res.getMessage());
//	}
	
	@Test
	public void orderTest3() {
		List<RoomVo> res=orderDao.joinTwoTables(LocalDate.of(2024, 01, 17),LocalDate.of(2024, 01, 18),"");
		for (RoomVo roomVo : res) {
			System.out.println(roomVo.getRoomId()+roomVo.getRoomName()+roomVo.getStartDate()+roomVo.getEndDate());
		}
	}

	@Test
	public void test() {
		String inputString = "[早餐,門票]";
		String resultString = inputString.substring(1, inputString.length() - 1);
		System.out.println(resultString);
	}
	
}
