package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.RoomTypeService;
import com.example.XiaoLiuqiu.vo.RoomTypeReq;
import com.example.XiaoLiuqiu.vo.RoomTypeRes;

@CrossOrigin
@RestController
public class RoomTypeServiceController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PostMapping(value = "room_type/search")
	public RoomTypeRes search(@RequestBody RoomTypeReq req) {
		return roomTypeService.search(req.getRoomTypeID(),req.getRoomTypeName(), req.getRoomTypePrice());
	}

}
