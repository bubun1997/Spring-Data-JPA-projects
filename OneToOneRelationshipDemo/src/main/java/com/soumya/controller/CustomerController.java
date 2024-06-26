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

import com.soumya.entity.Customer;
import com.soumya.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.addCustomer(customer));
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
		
		return ResponseEntity.ok(customerService.findCustomerById(id));
	}

}
