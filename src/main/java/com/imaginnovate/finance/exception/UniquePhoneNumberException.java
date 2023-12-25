package com.imaginnovate.finance.exception;

public class UniquePhoneNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UniquePhoneNumberException(String message) {
		super(message);
	}
}
