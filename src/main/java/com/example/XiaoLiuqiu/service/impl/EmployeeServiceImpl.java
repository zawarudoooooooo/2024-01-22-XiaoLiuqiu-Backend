package com.example.XiaoLiuqiu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.constants.EmployeeRole;
import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;
import com.example.XiaoLiuqiu.entity.Member;
import com.example.XiaoLiuqiu.repository.EmployeeDAO;
import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;
import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public EmployeeGetRes search(String account) {
		account = !StringUtils.hasText(account) ? "" : account;
		List<Employee> res = employeeDao.findByAccountContaining(account);
		return new EmployeeGetRes(RtnCode.SUCCESSFUL, res);
	}

	@Override
	public EmployeeLoginRes login(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		Optional<Employee> op = employeeDao.findByAccount(account);
		if (op.isEmpty()) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		Employee employee = op.get();
		if (!encoder.matches(pwd, employee.getPwd())) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}

		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeLoginRes create(String account, String pwd, Department department, int access, EmployeeRole role) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || role == null) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		
		if(employeeDao.existsByAccount(account)) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_EXISTED);
		}
		
		Employee employee = new Employee();
		employee.setAccount(account);
	    employee.setPwd(encoder.encode(pwd));
	    employee.setDepartment(department);
	    employee.setAccess(access);
	    employee.setRole(role);
	    employee.setActive(false);

	    employeeDao.save(employee);
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}
	
	@Override
	public EmployeeLoginRes update(int employeeId, String pwd, String newPwd, String confirmPwd) {
		if (employeeId <= 0) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		Optional<Employee> op = employeeDao.findById(employeeId);
		if (op.isEmpty()) {
			return new EmployeeLoginRes(RtnCode.PWD_NOT_FOUMD);
		}
		Employee employee = op.get();
		if (!encoder.matches(pwd, employee.getPwd())) {
			return new EmployeeLoginRes(RtnCode.PWD_ERROR);
		}
		if (!newPwd.equals(confirmPwd)) {
			return new EmployeeLoginRes(RtnCode.NEW_PWD_ERROR);
		}

		employee.setPwd(encoder.encode(newPwd));
		employeeDao.save(employee);
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeGetRes employeeSearch(String account) {
		if(!StringUtils.hasText(account)) {
			return new EmployeeGetRes(RtnCode.PARAM_ERROR,null);
		}
		
		Employee searcher = employeeDao.findByAccount2(account);
		List<Employee> res;
		
		switch (searcher.getAccess()) {
		case 100:
			res = employeeDao.findAll();
			break;
		case 50:
			res = employeeDao.findByDepartmentAndActive(searcher.getDepartment(), true);
			break;
		default:
			res = employeeDao.findByAccountAndActive(account, true);
			break;
		}
		
		return new EmployeeGetRes(RtnCode.SUCCESSFUL, res);
	}

	@Override
	public EmployeeLoginRes activeEmployee(String account) {
		if(!StringUtils.hasText(account)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		
		  Optional<Employee> optionalEmployee = employeeDao.findByAccount(account);
		 if(optionalEmployee.isEmpty()) {
			 return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		 }
		 
		 Employee employeeToUpdate = optionalEmployee.get();
		 if(employeeToUpdate.isActive() == true) {
			 return new EmployeeLoginRes(RtnCode.ACCOUNT_IS_ALREADY_ACTIVED);
		 }
		 employeeToUpdate.setActive(true);
		 employeeDao.save(employeeToUpdate);
		 
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeLoginRes deactiveEmployee(String loggedInAccount, String account) {
		if(!StringUtils.hasText(loggedInAccount) || !StringUtils.hasText(account)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		
		Employee updater = employeeDao.findByAccount2(loggedInAccount);
		if(updater.getAccount() == null || !updater.getRole().equals(EmployeeRole.ADMINISTRATIVE_SUPERVISOR)) {
			return new EmployeeLoginRes(RtnCode.ACCESS_IS_NOT_ALLOWED);
		}
		
		 Optional<Employee> optionalEmployee = employeeDao.findByAccount(account);
		if(optionalEmployee.isEmpty()) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		
		Employee employeeToUpdate = optionalEmployee.get();
		employeeToUpdate.setActive(false);
		employeeDao.save(employeeToUpdate);
		
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

}
