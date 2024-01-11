package com.example.XiaoLiuqiu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.RoomType;
import com.example.XiaoLiuqiu.repository.RoomTypeDAO;
import com.example.XiaoLiuqiu.service.ifs.RoomTypeService;
import com.example.XiaoLiuqiu.vo.RoomTypeGetRes;
import com.example.XiaoLiuqiu.vo.RoomTypeRes;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
	
	@Autowired
	private RoomTypeDAO roomTypeDao;

	@Override
	public RoomTypeRes search(int roomTypeId, String roomTypeName, int roomTypePrice) {
		roomTypeName = !StringUtils.hasText(roomTypeName) ? "" : roomTypeName;
		List<RoomType> res = roomTypeDao.findByRoomTypeNameContaining(roomTypeName);
		return new RoomTypeGetRes(RtnCode.SUCCESSFUL, res);
	}

}
