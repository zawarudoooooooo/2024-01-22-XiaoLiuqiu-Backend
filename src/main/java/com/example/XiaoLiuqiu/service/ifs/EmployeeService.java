package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;

public interface EmployeeService {
	
	public EmployeeGetRes search(String account);
	
	public EmployeeGetRes employeeSearch(String account);
	
	public EmployeeLoginRes login(String account, String pwd);

	public EmployeeLoginRes create(String account, String pwd);
	
	public EmployeeLoginRes createMaster(String account, String pwd, boolean access);
	
	public EmployeeLoginRes update(int employeeId,String pwd, String newPwd, String confirmPwd);

}
