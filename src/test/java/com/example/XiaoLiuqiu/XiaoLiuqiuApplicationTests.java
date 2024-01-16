package com.example.XiaoLiuqiu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;

@SpringBootTest
class XiaoLiuqiuApplicationTests {
	
	@Autowired
	public EmployeeService employeeService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void employeeTest() {
//		EmployeeLoginRes res=employeeService.create("As01", "qaz159", true);
//		System.out.println(res.getRtncode());
	}

}
