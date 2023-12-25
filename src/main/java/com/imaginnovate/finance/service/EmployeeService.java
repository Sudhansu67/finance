package com.imaginnovate.finance.service;

import java.util.List;

import com.imaginnovate.finance.dto.EmployeeDto;
import com.imaginnovate.finance.dto.EmployeeTaxDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	public EmployeeDto getEmployeeById(int empId); 
	
	public List<EmployeeDto> getEmployeeList();
	
	public EmployeeTaxDto getEmployeeTax(int empId);
	
	public boolean isEmailExists(String email);
	
	public boolean isPhoneNumberExists(long phoneNumber);
}
