package com.example.XiaoLiuqiu;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.constants.EmployeeRole;
import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;
import com.example.XiaoLiuqiu.repository.EmployeeDAO;
import com.example.XiaoLiuqiu.service.impl.EmployeeServiceImpl;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;

@SpringBootTest
public class EmployeeServiceTest {
	
//	@Autowired
//	private EmployeeDAO employeeDao;
//	
//	@Test
//	public void testCreateEmployeeAsTopManagement() {
//		// 準備測試數據
//		String account = "john.doe";
//		String password = "password123";
//	    Department department = Department.HR;
//	    boolean isSupervisor = true;
//	    EmployeeRole role = EmployeeRole.ADMINISTRATIVE_SUPERVISOR;
//
//	    // 模擬一個登入的最高管理者
//	    Employee loggedInEmployee = mock(Employee.class);
//	    when(loggedInEmployee.isTopManagement()).thenReturn(true);
//
//	    // 模擬 EmployeeDao
//	    EmployeeDAO employeeDao = mock(EmployeeDAO.class);
//
//	    // 模擬 EmployeeServiceImpl
//	    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//	    employeeService.setEmployeeDao(employeeDao);
//
//	    // 設置模擬的登入員工
//	    employeeService.setLoggedInEmployee(loggedInEmployee);
//
//	    // 呼叫測試的方法
//	    EmployeeLoginRes result = employeeService.create(account, password, department, isSupervisor, role);
//
//	    // 驗證結果
//	    assertEquals(RtnCode.SUCCESSFUL, result.getCode());
//
//	    // 驗證在Dao中是否正確保存
//	    // 在這裡你可以使用模擬的 EmployeeDao 來驗證是否呼叫了相應的方法
//	    }

}
