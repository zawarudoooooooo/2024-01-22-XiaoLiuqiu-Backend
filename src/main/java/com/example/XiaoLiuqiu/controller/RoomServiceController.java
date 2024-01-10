package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.RoomService;
import com.example.XiaoLiuqiu.vo.RoomReq;
import com.example.XiaoLiuqiu.vo.RoomRes;

@CrossOrigin
@RestController
public class RoomServiceController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping(value = "room/search")
	public RoomRes search(@RequestBody RoomReq req) {
		return roomService.search(req.getRoomId());
		
	}

}
