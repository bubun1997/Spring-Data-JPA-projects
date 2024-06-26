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

import com.soumya.entity.Course;
import com.soumya.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
	}
	
	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses(){
		
		return ResponseEntity.ok(courseService.getAllCourses());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id){
		
		return ResponseEntity.ok(courseService.getCourseById(id));
	}
	
	

}
