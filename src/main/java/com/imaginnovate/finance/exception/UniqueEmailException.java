package com.imaginnovate.finance.exception;

public class UniqueEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UniqueEmailException(String message) {
		super(message);
	}
}
