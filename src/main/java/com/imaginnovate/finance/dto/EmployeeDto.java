package com.imaginnovate.finance.dto;

import com.imaginnovate.finance.validators.ValidDate;
import com.imaginnovate.finance.validators.ValidPhoneNumber;
import com.imaginnovate.finance.validators.ValidSalary;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDto {

	private int Id;
	
	@NotBlank(message = "The firstName is required.")
	@Pattern(regexp = "[a-zA-Z]*", message = "The firstName must contains alphabets only.")
	@Size(min = 3, max = 50, message = "The length of firstName must be between 3 and 50 characters.")
	private String firstName;
	
	
	@NotBlank(message = "The lastName is required.")
	@Pattern(regexp = "[a-zA-Z]*", message = "The lastName must contains alphabets only.")
	@Size(min = 3, max = 50, message = "The length of lastName must be between 3 and 50 characters.")
	private String lastName;
	
	@NotBlank(message = "The email is required.")
	@Email(message = "Please enter a valid email.")
	@Size(min = 3, max = 50, message = "The length of email must be between 3 and 50 characters.")
	private String email;
	
	@NotNull(message = "The phoneNumber is required.")
	@Positive(message = "The phoneNumber shouldn't be -ve value.")
	@ValidPhoneNumber
	private long phoneNumber;
	
	@NotBlank(message = "The doj is required.")
	@ValidDate
	private String doj;
	
	@NotNull(message = "The salary is required.")
	@Positive(message = "The salary shouldn't be -ve value.")
	@ValidSalary
	private double salary;
}
