package com.imaginnovate.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.finance.dto.EmployeeDto;
import com.imaginnovate.finance.dto.EmployeeTaxDto;
import com.imaginnovate.finance.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<EmployeeDto> getEmployeeList() {
		return employeeService.getEmployeeList();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		employeeDto.setId(0);
		return employeeService.saveEmployee(employeeDto);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}
	
	@GetMapping("/{empId}")
	public EmployeeDto getEmployee(@PathVariable int empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@GetMapping("/taxCalculation/{empId}")
	public EmployeeTaxDto getEmployeeTax(@PathVariable int empId) {
		return employeeService.getEmployeeTax(empId);
	}
}
