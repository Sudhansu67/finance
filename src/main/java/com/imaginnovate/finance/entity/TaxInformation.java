package com.imaginnovate.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tax_information")
public class TaxInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private double taxPercentage;
	
	private double fromAmount;
	
	private double toAmount;
}
