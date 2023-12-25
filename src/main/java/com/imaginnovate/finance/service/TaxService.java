package com.imaginnovate.finance.service;

import java.util.List;

import com.imaginnovate.finance.dto.EmployeeTaxDto;
import com.imaginnovate.finance.entity.Employee;
import com.imaginnovate.finance.entity.TaxInformation;

public interface TaxService {

	public List<TaxInformation> getTaxInformationList();
	
	public EmployeeTaxDto calculateTaxDeduction(Employee employee);
}
