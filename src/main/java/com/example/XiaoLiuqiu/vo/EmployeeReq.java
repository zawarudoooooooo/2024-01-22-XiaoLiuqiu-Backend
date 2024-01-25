package com.example.XiaoLiuqiu.vo;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.constants.EmployeeRole;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeReq {

	private String account;

	@JsonProperty(value = "password")
	private String pwd;

	private int access;

	private EmployeeRole role;
	
	private Department department;
	
	private boolean active;

	public EmployeeReq() {
		super();
	}

	public EmployeeReq(String account, String pwd, int access, EmployeeRole role, Department department,
			boolean active) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.access = access;
		this.role = role;
		this.department = department;
		this.active = active;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
