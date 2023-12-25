package com.imaginnovate.finance.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		String longValue = String.valueOf(value.longValue());
		if (value.longValue() > 0 && !longValue.startsWith("0") && longValue.length() == 10) {
			return true;
		}
		return false;
	}

}
