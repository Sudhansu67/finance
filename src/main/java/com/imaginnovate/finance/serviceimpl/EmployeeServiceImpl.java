package com.imaginnovate.finance.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.finance.dto.EmployeeDto;
import com.imaginnovate.finance.dto.EmployeeTaxDto;
import com.imaginnovate.finance.entity.Employee;
import com.imaginnovate.finance.exception.EmployeeNotFoundException;
import com.imaginnovate.finance.exception.UniqueEmailException;
import com.imaginnovate.finance.exception.UniquePhoneNumberException;
import com.imaginnovate.finance.mapper.EmployeeMapper;
import com.imaginnovate.finance.repository.EmployeeRepository;
import com.imaginnovate.finance.service.EmployeeService;
import com.imaginnovate.finance.service.TaxService;
import com.imaginnovate.finance.util.FinanceConstant;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TaxService taxService;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.toEmployee(employeeDto);
		
		if (isEmailExists(employeeDto.getEmail())) {
			throw new UniqueEmailException(FinanceConstant.UNIQUE_EMAIL);
		}
		
		if (isPhoneNumberExists(employeeDto.getPhoneNumber())) {
			throw new UniquePhoneNumberException(FinanceConstant.UNIQUE_PHONE_NUMBER);
		}
		
		employee = employeeRepository.save(employee);
		return EmployeeMapper.toEmployeeDto(employee);
	}
	
	@Override
	public EmployeeDto getEmployeeById(int empId) {
		Optional<Employee> empOptional = employeeRepository.findById(empId);
		if (empOptional.isPresent()) {
			return EmployeeMapper.toEmployeeDto(empOptional.get());
		} else {
			throw new EmployeeNotFoundException(FinanceConstant.Employee_NOT_FOUND);
		}
		
	}

	@Override
	public List<EmployeeDto> getEmployeeList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return EmployeeMapper.toEmployeeDtoList(employeeList);
	}

	@Override
	public EmployeeTaxDto getEmployeeTax(int empId) {
		Optional<Employee> empOptional = employeeRepository.findById(empId);
		if (empOptional.isPresent()) {
			return taxService.calculateTaxDeduction(empOptional.get());
		} else {
			throw new EmployeeNotFoundException(FinanceConstant.Employee_NOT_FOUND);
		}
	}

	@Override
	public boolean isEmailExists(String email) {
		return employeeRepository.existsByEmail(email);
	}

	@Override
	public boolean isPhoneNumberExists(long phoneNumber) {
		return employeeRepository.existsByPhoneNumber(phoneNumber);
	}
	
}
