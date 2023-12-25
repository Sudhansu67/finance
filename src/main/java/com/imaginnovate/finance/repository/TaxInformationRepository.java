package com.imaginnovate.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.finance.entity.TaxInformation;

@Repository
public interface TaxInformationRepository extends JpaRepository<TaxInformation, Integer> {
	
}
