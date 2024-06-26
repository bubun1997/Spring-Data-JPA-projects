package com.soumya.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "emp_dept")
	private String department;
	
	@Column(name = "emp_salary")
	private Double salary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Laptop> laptopsAssigned;

}
