package com.example.XiaoLiuqiu.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Extra;
import com.example.XiaoLiuqiu.entity.Orders;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.repository.OrdersDAO;
import com.example.XiaoLiuqiu.service.ifs.OrdersService;
import com.example.XiaoLiuqiu.vo.OrdersGetRes;
import com.example.XiaoLiuqiu.vo.OrdersRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class OrdersServiceImpl implements OrdersService{
	
//	字串與物件(類別)互轉
	private ObjectMapper mapper=new ObjectMapper();
	
	@Autowired
	private OrdersDAO orderDao;
	
	@Override
	public OrdersRes search( LocalDate startDate, LocalDate endDate) {
			startDate = startDate == null ? startDate = LocalDate.of(1970, 01, 01) : startDate;
			endDate = endDate == null ? endDate = LocalDate.of(2099, 12, 31) : endDate;
			List<Orders> res = orderDao.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
			return new OrdersGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}
	
//	@Override
//	public OrdersRes search(List<Room> roomId, LocalDate startDate, LocalDate endDate) {
//		roomId = roomId==null ? Collections.emptyList()  :roomId;
//		startDate = startDate == null ? startDate = LocalDate.of(1970, 01, 01) : startDate;
//		endDate = endDate == null ? endDate = LocalDate.of(2099, 12, 31) : endDate;
//		List<Orders> res = orderDao.findByLike(roomId, startDate, endDate);
//		return new OrdersGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
//
//	}

	@Override
	public OrdersRes ordersCreate(int memberId, List<Room> roomIdStr, List<Extra> orderItemStr, LocalDate startDate,
			LocalDate endDate) {
		if (memberId == 0|| startDate == null || endDate == null) {
			return new OrdersRes(RtnCode.PARAM_ERROR.getCode(), RtnCode.PARAM_ERROR.getMessage());
		}
		if (startDate.isAfter(endDate)) {
			return new OrdersRes(RtnCode.DATE_FORMAT_ERROR.getCode(), RtnCode.DATE_FORMAT_ERROR.getMessage());
		}try {
			String roomId=mapper.writeValueAsString(roomIdStr);
			String orderItem=mapper.writeValueAsString(orderItemStr);
			orderDao.save(new Orders(memberId,roomId,orderItem,startDate,endDate,LocalDateTime.now()));
			return new OrdersRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
		} catch (JsonProcessingException e) {
			return new OrdersRes(RtnCode.ORDER_CREATE_ERROR.getCode(), RtnCode.ORDER_CREATE_ERROR.getMessage());
		}
	}


	
	
	
	
	

//	@Override
//	public OrdersRes ordersCreate(int memberId, List<Room> roomId, List<Extra> orderItem, LocalDate startDate,
//			LocalDate endDate) {
//		if (memberId != 0||!roomId.isEmpty()||!orderItem.isEmpty()|| startDate == null || endDate == null) {
//			return new OrdersRes(RtnCode.PARAM_ERROR.getCode(), RtnCode.PARAM_ERROR.getMessage());
//		}
//		if (startDate.isAfter(endDate)) {
//			return new OrdersRes(RtnCode.DATE_FORMAT_ERROR.getCode(), RtnCode.DATE_FORMAT_ERROR.getMessage());
//		}
//		try {
//			String roomIdStr=mapper.writeValueAsString(roomId);
//			String orderItemStr=mapper.writeValueAsString(orderItem);
//			orderDao.save(new Orders(memberId,roomIdStr,orderItemStr,startDate,endDate));
//			return new OrdersRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
//		} catch (JsonProcessingException e) {
//			return new OrdersRes(RtnCode.ORDER_CREATE_ERROR.getCode(), RtnCode.ORDER_CREATE_ERROR.getMessage());
//		}
//	}
	
	

}
