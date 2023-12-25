package com.imaginnovate.finance.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.finance.dto.EmployeeTaxDto;
import com.imaginnovate.finance.entity.Employee;
import com.imaginnovate.finance.entity.TaxInformation;
import com.imaginnovate.finance.repository.TaxInformationRepository;
import com.imaginnovate.finance.service.TaxService;
import com.imaginnovate.finance.util.FinanceConstant;

@Service
public class TaxServiceImpl implements TaxService {
	
	@Autowired
	private TaxInformationRepository taxInformationRepository;

	@Override
	public List<TaxInformation> getTaxInformationList() {
		return taxInformationRepository.findAll();
	}
	
	public EmployeeTaxDto calculateTaxDeduction(Employee employee) {
		LocalDate fyLocalDate = LocalDate.now();
		int fyYear = fyLocalDate.getYear();
		
		LocalDate doj = employee.getDoj();
		int dojYear = doj.getYear();
		int dojMonth = doj.getMonthValue();
		int dojDay = doj.getDayOfMonth();
		int dojTotalDaysInMonth = doj.lengthOfMonth();
		
		int diffYear = fyYear - dojYear;
		int diffMonths = 0;
		int diffDays = 0;
		
		//calculation of months and days if employee joined in same Financial Year.
		if (diffYear == 0) {
			if (dojMonth < 4) {
				diffMonths = 12;
			} else {
				diffMonths = (12 - dojMonth) + 3;
				if (dojDay == 1) {
					diffMonths++;
				} else {
					diffDays = dojTotalDaysInMonth - dojDay;
				}
			}
		} else if (diffYear >= 1) {
			diffMonths = 12;
		} else if (diffYear == -1 && dojMonth < 4) {
			diffMonths = 4 - dojMonth;
			if (dojDay == 1) {
				diffMonths++;
			} else {
				diffDays = dojTotalDaysInMonth - dojDay;
			}
		}
		
		List<TaxInformation> taxList = getTaxInformationList();
		final double totalSalary = 
				(Math.round(employee.getSalary()/30) * diffDays) + (employee.getSalary() * diffMonths);
		
		//find tax slabs where employee salary fit
		taxList = taxList.stream()
				.filter(t -> totalSalary >= t.getFromAmount())
				.collect(Collectors.toList());
		
		double taxAmount = 0;
		
		//Calculate Tax slab wise
		if (totalSalary > 0) {
			for (int i = 0; i < taxList.size(); i++) {
				TaxInformation taxSlab = taxList.get(i);
				if (totalSalary > taxSlab.getToAmount()) {
					taxAmount = taxAmount + 
							Math.round(((taxSlab.getToAmount() - taxSlab.getFromAmount()) * taxSlab.getTaxPercentage()) / 100);
					System.out.println("IF: Tax = "+taxSlab.getToAmount()+" - "+taxSlab.getFromAmount()+" & Amount="+taxAmount);
				} else {
					taxAmount = taxAmount + 
							Math.round(((totalSalary - taxSlab.getFromAmount()) * taxSlab.getTaxPercentage()) / 100);
					System.out.println("ELSETax = "+taxSlab.getToAmount()+" - "+taxSlab.getFromAmount()+" & Amount="+taxAmount);
				}
			}
		}
		
		//If employee is eligible for CESS Tax
		if (totalSalary > FinanceConstant.CESS_TAX_AMOUNT) {
			double cessAmount = 
					Math.round(((totalSalary - FinanceConstant.CESS_TAX_AMOUNT) * FinanceConstant.CESS_TAX_PERCENTAGE) / 100);;
			System.out.println("CESS Amount: "+cessAmount);
			taxAmount = taxAmount + cessAmount;		
		}
		
		double inHandSalary = totalSalary - taxAmount;
		
		EmployeeTaxDto employeeTaxDto = new EmployeeTaxDto();
		employeeTaxDto.setEmployeeId(employee.getId());
		employeeTaxDto.setTotalSalary(FinanceConstant.ZERO_DECIMAL.format(totalSalary));
		employeeTaxDto.setTaxDeduction(FinanceConstant.ZERO_DECIMAL.format(taxAmount));
		employeeTaxDto.setInHandSalary(FinanceConstant.ZERO_DECIMAL.format(inHandSalary));
		
		return employeeTaxDto; 
				
	}

}
