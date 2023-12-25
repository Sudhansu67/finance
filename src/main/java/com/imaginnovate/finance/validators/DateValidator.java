package com.imaginnovate.finance.validators;

import java.time.LocalDate;

import com.imaginnovate.finance.util.FinanceConstant;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {	
		try {
			LocalDate.parse(value, FinanceConstant.DD_MM_YYYY);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
