package com.imaginnovate.finance.dto;

import lombok.Data;

@Data
public class EmployeeTaxDto {

	private int employeeId;
	
	private String totalSalary;
	
	private String taxDeduction;
	
	private String inHandSalary;
}
