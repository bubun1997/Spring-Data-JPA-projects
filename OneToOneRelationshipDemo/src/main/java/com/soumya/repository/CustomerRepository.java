package com.soumya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
