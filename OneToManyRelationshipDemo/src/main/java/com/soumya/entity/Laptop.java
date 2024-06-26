package com.soumya.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "laptop_id")
	private Long laptopId;
	
	@Column(name = "brand_name")
	private String laptopBrand;
	
	@Column(name = "laptop_price")
	private Double laptopPrice;
	
	@ManyToOne
	@JoinColumn(name = "employee_id",referencedColumnName = "emp_id")
	@JsonBackReference
	private Employee employee;
	
	
	
	

}
