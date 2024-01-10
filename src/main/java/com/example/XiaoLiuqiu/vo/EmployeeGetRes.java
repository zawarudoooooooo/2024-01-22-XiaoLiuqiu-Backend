package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;

public class EmployeeGetRes extends EmployeeRes{
	
	private List<Employee> employeeList;

	public EmployeeGetRes() {
		super();
	}

	public EmployeeGetRes(RtnCode rtnCode,List<Employee> employeeList) {
		super(rtnCode);
		this.employeeList = employeeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	
	
}
