package com.example.XiaoLiuqiu.repository;

import org.springframework.stereotype.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.XiaoLiuqiu.entity.Car;



@Repository
public interface CarDAO extends JpaRepository<Car, String>{
	public List<Car>findAll(String carId, int carTypeId, String carIntroduce);
	public List<Car>findByCarIdContainingAndCarTypeIdAndCarIntroduceContaining(String carId, int carTypeId, String carIntroduce);
	public List<Car>findByCarIdContainingAndCarIntroduceContaining(String carId,  String carIntroduce);
}
