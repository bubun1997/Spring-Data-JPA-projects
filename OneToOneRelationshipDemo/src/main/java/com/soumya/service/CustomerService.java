package com.soumya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.entity.Customer;
import com.soumya.exception.CustomerNotFoundException;
import com.soumya.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
	}
	
	public Customer addCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomers(){
		
		return this.customerRepository.findAll();
	}
	
	public Customer findCustomerById(Long id) {
		
		return this.customerRepository.
				    findById(id).
				    orElseThrow(() -> CustomerNotFoundException.
				    				  builder().
				    				  message("Customer Not found with id : "+id).
				    				  build());
	}
}
