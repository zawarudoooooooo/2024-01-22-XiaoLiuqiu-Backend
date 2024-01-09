package com.example.XiaoLiuqiu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.XiaoLiuqiu.entity.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByRoomIdContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual
	(String roomId, LocalDate startDate, LocalDate endDate);

}
