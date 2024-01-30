package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.constants.EmployeeRole;

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
	private int access;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
    private EmployeeRole role;

	@Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "resignation")
	private boolean resignation;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String account, String pwd, int access, EmployeeRole role,
			Department department, boolean active, boolean resignation) {
		super();
		this.employeeId = employeeId;
		this.account = account;
		this.pwd = pwd;
		this.access = access;
		this.role = role;
		this.department = department;
		this.active = active;
		this.resignation = resignation;
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

	public boolean isDepartmentAccess(Department targetDepartment) {
		return department != null && department.equals(targetDepartment);
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isResignation() {
		return resignation;
	}

	public void setResignation(boolean resignation) {
		this.resignation = resignation;
	}

}
