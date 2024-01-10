package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeReq;

@CrossOrigin
@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "employee/search")
	public EmployeeGetRes search(@RequestBody EmployeeReq req) {
		return employeeService.search(req.getAccount());
	}
	
//	@PostMapping(value = "employee/search")
//	public 

}
