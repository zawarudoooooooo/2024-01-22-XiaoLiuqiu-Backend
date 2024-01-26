package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.CarSearchRes;

public interface CarService {
public CarSearchRes search(String carId, int carTypeId, String carIntroduce);
public CarSearchRes carPhoto(String carId, int carTypeId, String carIntroduce);
}
