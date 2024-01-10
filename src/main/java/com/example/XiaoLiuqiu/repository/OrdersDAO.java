package com.example.XiaoLiuqiu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Orders;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByRoomIdContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual
	(String roomId, LocalDate startDate, LocalDate endDate);

}
