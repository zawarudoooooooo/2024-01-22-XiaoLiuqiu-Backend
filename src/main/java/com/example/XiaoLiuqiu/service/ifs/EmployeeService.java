package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeRes;

public interface EmployeeService {
	
	public EmployeeGetRes search(String account);
	
	public EmployeeRes login(String account, String pwd);
	
	public EmployeeRes create(String account, String pwd);
	
	

}
