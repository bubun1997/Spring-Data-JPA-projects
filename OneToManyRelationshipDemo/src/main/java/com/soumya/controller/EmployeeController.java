package com.soumya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.entity.Employee;
import com.soumya.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeService.addEmployee(emp));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		return ResponseEntity.ok(this.employeeService.getAllEmployees());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		return ResponseEntity.ok(this.employeeService.getEmployeeById(id));
	}
	
	@GetMapping("/dept/{dept}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String dept){
		
		return ResponseEntity.ok(this.employeeService.getEmployeeByDepartment(dept));
	}

}
