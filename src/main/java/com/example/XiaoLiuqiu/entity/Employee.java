package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "access")
	private boolean access;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String account, String pwd, boolean access) {
		super();
		this.employeeId = employeeId;
		this.account = account;
		this.pwd = pwd;
		this.access = access;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}


}
