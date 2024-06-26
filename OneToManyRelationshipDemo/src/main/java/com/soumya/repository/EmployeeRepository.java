package com.soumya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> findByDepartment(String dept);

}
