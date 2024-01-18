package com.example.XiaoLiuqiu;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersRes;

@SpringBootTest
public class OrdersServiceTtest {

	
	@Autowired
	public OrdersService ordersService;
	
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
	
	
}
