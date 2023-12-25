package com.imaginnovate.finance.util;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class FinanceConstant {

	public final static DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public final static DateTimeFormatter DD_MM_YYYY_T_HH_MM_SS = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
	
	public final static String Employee_NOT_FOUND = "Employee not found"; 
	
	public final static DecimalFormat ZERO_DECIMAL = new DecimalFormat("#"); 
	
	public final static int LOSS_OF_PAY_PER_DAY = 30;
	
	public final static int CESS_TAX_AMOUNT = 25_00_000;
	
	public final static int CESS_TAX_PERCENTAGE = 2;
	
	//Response Messages
	public final static String INVALID_INPUT = "Invalid input";
	public final static String UNIQUE_EMAIL = "email is already exist";
	public final static String UNIQUE_PHONE_NUMBER = "phoneNumber is already exist";
}
