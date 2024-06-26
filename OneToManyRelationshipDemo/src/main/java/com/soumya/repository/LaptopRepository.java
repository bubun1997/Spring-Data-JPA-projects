package com.soumya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
