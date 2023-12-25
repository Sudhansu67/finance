package com.imaginnovate.finance.dto;

import lombok.Data;

@Data
public class ErrorDto {

	private int code;

	private String message;
	
	private String time;
	
}
