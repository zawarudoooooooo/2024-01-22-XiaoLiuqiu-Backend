package com.example.XiaoLiuqiu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Car;
import com.example.XiaoLiuqiu.repository.CarDAO;
import com.example.XiaoLiuqiu.service.ifs.CarService;
import com.example.XiaoLiuqiu.vo.CarSearchRes;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDAO carDAO;

	@Override
	public CarSearchRes search(String carId, int carTypeId, String carIntroduce) {
		carId = !StringUtils.hasText(carId) ? "" : carId;
		carTypeId = carTypeId == 0 ? 0 : carTypeId;
		carIntroduce = !StringUtils.hasText(carIntroduce) ? "" : carIntroduce;
		List<Car> res = new ArrayList<>();
		if (carId!=""||carTypeId != 0||carIntroduce!="") {
			res = carDAO.findByCarIdContainingAndCarTypeIdAndCarIntroduceContaining(carId, carTypeId, carIntroduce);
		} else {
			res = carDAO.findAll();
		}
		
		return new CarSearchRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());

	}

	@Override
	public CarSearchRes create(String carId, int carTypeId, String carIntroduce) {
		if(carId==""|| carTypeId == 0||carIntroduce=="") {
			return new CarSearchRes(RtnCode.PARAM_ERROR.getCode(), RtnCode.PARAM_ERROR.getMessage());
		}
		if(carDAO.existsByCarId(carId)) {
			return new CarSearchRes(RtnCode.CAR_EXISTED_ERROR.getCode(), RtnCode.CAR_EXISTED_ERROR.getMessage());
		}
		carDAO.save(new Car(carId,carTypeId,carIntroduce));
		return new CarSearchRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

}
