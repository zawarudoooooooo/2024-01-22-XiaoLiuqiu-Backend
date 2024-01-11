package com.example.XiaoLiuqiu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersRes;

@SpringBootTest
public class OrdersServiceTtest {

	
	@Autowired
	public OrdersService ordersService;
	
	@Test
	public void orderTest() {
		List<Room> room=Arrays.asList(
				new Room("A01",1,"這是單人房"),
				new Room("A02",1,"這是單人房2"));
		List<Extra> order=Arrays.asList(
				new Extra(1,"早餐",200),
				new Extra(2,"門票",500)
				);
		OrdersRes res=ordersService.ordersCreate(1, room , order, LocalDate.now(), LocalDate.now().plusDays(1));
		System.out.println(res.getCode()+res.getMessage());
	}
}
