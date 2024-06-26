package com.soumya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
