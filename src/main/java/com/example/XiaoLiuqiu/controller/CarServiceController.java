package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.CarService;
import com.example.XiaoLiuqiu.vo.CarSearchReq;
import com.example.XiaoLiuqiu.vo.CarSearchRes;

@CrossOrigin
@RestController
public class CarServiceController {
	@Autowired
	private CarService carService;
	@PostMapping(value="car/search")
	public CarSearchRes search(@RequestBody CarSearchReq req) {
		return carService.search(req.getCarId(), req.getCarTypeId(), req.getCarIntroduce());
	}
	@PostMapping(value="car/carPhoto")
	public CarSearchRes carPhoto(@RequestBody CarSearchReq req) {
		return carService.carPhoto(req.getCarId(), req.getCarTypeId(), req.getCarIntroduce());
	}
	}
