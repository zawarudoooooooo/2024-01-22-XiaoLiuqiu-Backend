package com.example.XiaoLiuqiu.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.constants.EmployeeRole;
import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;
import com.example.XiaoLiuqiu.repository.EmployeeDAO;
import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeLoginReq;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;
import com.example.XiaoLiuqiu.vo.EmployeeReq;
import com.example.XiaoLiuqiu.vo.EmployeeUpdateReq;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

@CrossOrigin
@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDAO employeeDao;
	
//	@PostMapping(value = "employee/search")
//	public EmployeeGetRes search(@RequestBody EmployeeReq req) {
//		if(req == null) {
//			return new EmployeeGetRes(RtnCode.PARAM_ERROR, null);
//		}
//		String account = req.getAccount();
//		Department department = req.getDepartment();
//		EmployeeRole role = req.getRole();
//		
//		List<Employee> res;
//		
//		return employeeService.search(req.getAccount());
//	}
	
	@PostMapping(value = "employee/employeeSearch")
	public EmployeeGetRes employeeSearch(@RequestParam String account, HttpSession session) {
		System.out.println(session.getId());	
		return employeeService.employeeSearch(account);
	}
	
	@PostMapping(value = "employee/login")
	public EmployeeLoginRes login(@RequestBody EmployeeLoginReq req, HttpSession session ,HttpServletResponse response) {
		System.out.println(session.getId());	
		String attr = (String)session.getAttribute("account");
		if(StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
		}
		EmployeeLoginRes res = employeeService.login(req.getAccount(), req.getPwd());
		if(res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			
			Optional<Employee> op = employeeDao.findByAccount(req.getAccount());
			if(op.isPresent()) {
				Employee employee = op.get();
				
				Cookie memberIdCookie = new Cookie("employee", req.getAccount() + ":" + employee.getAccess() + ":" + employee.isActive());
				memberIdCookie.setMaxAge(600); 
				memberIdCookie.setPath("/");
				response.addCookie(memberIdCookie);
			}
		}
		return res;
	}
	
	@PostMapping(value="employee/logout")
	public MemberLoginRes logout(HttpSession session ,HttpServletResponse response) {
		Cookie employeeCookie = new Cookie("employee", "");
		employeeCookie.setMaxAge(0); 
		employeeCookie.setPath("/");
        response.addCookie(employeeCookie);
		
		session.invalidate();
		System.out.println(session.getId());
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage()) ;
		
	}

	@PostMapping(value = "employee/create")
	public EmployeeLoginRes create(@RequestBody EmployeeReq req, HttpSession session) {
		System.out.println(session.getId());
		String loggedInAccount = (String) session.getAttribute("account");
		 if (StringUtils.hasText(loggedInAccount)) {
		     Employee loggedInEmployee = employeeDao.findByAccount2(loggedInAccount);
		     // 檢查用戶是否為人事主管且擁有新增員工的權限
		     if (loggedInEmployee != null && loggedInEmployee.getRole() == EmployeeRole.ADMINISTRATIVE_SUPERVISOR) {
		         // 3. 如果有權限，執行新增員工的操作
		         return employeeService.create(req.getAccount(), req.getPwd(), req.getDepartment(), req.getAccess(), req.getRole());
		     } else {
		         return new EmployeeLoginRes(RtnCode.ACCESS_IS_NOT_ALLOWED);
		     }
		 } else {
		        return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		    }
	}
	
	@PostMapping(value = "employee/update")
	public EmployeeLoginRes update(@RequestParam int employeeId, @RequestBody EmployeeUpdateReq req) {
		return employeeService.update(employeeId, req.getPwd(), req.getNewPwd(), req.getConfirmPwd());
	}
	
	@PostMapping(value = "employee/active")
	public EmployeeLoginRes activeEmployee(@RequestParam String account, HttpSession session) {
		System.out.println(session.getId());
		return employeeService.activeEmployee(account);
	}
	
	@PostMapping(value = "employee/deactive")
	public EmployeeLoginRes deactiveEmployee(@RequestParam String account, HttpSession session) {
		System.out.println(session.getId());
		String loggedInAccount = (String) session.getAttribute("account");
		Employee loggedInRole = employeeDao.findByAccount2(loggedInAccount);
		if(!loggedInRole.getRole().equals(EmployeeRole.ADMINISTRATIVE_SUPERVISOR)) {
			return new EmployeeLoginRes(RtnCode.ACCESS_IS_NOT_ALLOWED);
		}
		
		return employeeService.deactiveEmployee(loggedInAccount, account);
	}

}
