package com.imaginnovate.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.finance.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByEmail(String email);
	
	boolean existsByPhoneNumber(long phoneNumber);
}
