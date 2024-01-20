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
	
	@Test
	public void orderTest1() {
		List<Room> room=Arrays.asList(
				new Room("A01","這是單人房","單人房",1500,true),
				new Room("A02","這是單人房","單人房",1500,true));
		List<Extra> order=Arrays.asList(
				new Extra("早餐",200),
				new Extra("門票",500)
				);
		OrdersRes res=ordersService.ordersCreate("Roy", room , order, 
				LocalDate.now(), LocalDate.now().plusDays(1),true,false);
		System.out.println(res.getCode()+res.getMessage());
	}
	
	@Test
	public void orderTest2() {
		List<Room> room=Arrays.asList(
				new Room("C02","舒適的雙人房間","舒適雙人房",3000,true));
		List<Extra> order=Arrays.asList(
				new Extra("早餐",200)
				);
		OrdersRes res=ordersService.ordersCreate("Roy", room , order, 
				LocalDate.now(), LocalDate.now().plusDays(1),true,false);
		System.out.println(res.getCode()+res.getMessage());
	}
	
	private ObjectMapper mapper = new ObjectMapper();
	@Test
	public void orderTest3() {
		Orders order=new Orders();
		Optional<Orders> op = orderDao.findById(6);
//		Optional<Orders> op = orderDao.findByName("");
		
		order=op.get();
		StringBuffer buff = new StringBuffer();
		String roomStr = order.getRoomId();
		List<Map<String, Object>> list;
		try {
			list = mapper.readValue(roomStr, List.class);
			for(Map<String, Object> item : list) {
				buff.setLength(0);
				for(Entry<String, Object> mapItem : item.entrySet()) {
					if(mapItem.getKey().equalsIgnoreCase("roomId")) {
						buff.append(mapItem.getValue());
//						System.out.println(buff.toString());
						Optional<Room> roomRes=roomDao.findById(buff.toString());
						Room room=roomRes.get();
						
						System.out.println(room.getRoomId());
						System.out.println(room.getRoomName());
					}
				}
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			 System.err.println("Error processing JSON: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
}
