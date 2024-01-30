package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.RoomTypeService;
import com.example.XiaoLiuqiu.vo.RoomTypeRes;

@CrossOrigin
@RestController
public class RoomTypeServiceController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PostMapping(value = "roomtype/createroomtype")
	public RoomTypeRes createRoomType(@RequestParam String roomTypeName) {
		return roomTypeService.createRoomType(roomTypeName);
	}
	
	@PostMapping(value = "roomtype/search")
	public RoomTypeRes search(@RequestParam String roomTypeName) {
		return roomTypeService.search(roomTypeName);
	}

}
