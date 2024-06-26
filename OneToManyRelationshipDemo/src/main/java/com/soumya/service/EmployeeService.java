package com.soumya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.entity.Employee;
import com.soumya.exception.EmployeeNotFoundException;
import com.soumya.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee addEmployee(Employee emp) {
		
		return this.employeeRepository.save(emp);
	}

	public List<Employee> getAllEmployees(){
		
		return this.employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		
		return this.employeeRepository.
				    findById(id).
				    orElseThrow(() -> EmployeeNotFoundException.
				    				  builder().
				    				  message("Employee not found with id : "+id).
				    				  build());
	}
	
	
	public Employee getEmployeeByDepartment(String dept) {
		
		return this.employeeRepository.
				    findByDepartment(dept).
				    orElseThrow(() -> EmployeeNotFoundException.
				    				  builder().
				    				  message("Employee not found with department : "+dept).
				    				  build());
	}
}
