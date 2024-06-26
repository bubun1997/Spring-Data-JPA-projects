package com.soumya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.entity.Student;
import com.soumya.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return ResponseEntity.ok(this.studentService.getAllStudents());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		
		return ResponseEntity.ok(this.studentService.findStudentById(id));
	}
	
	@PutMapping("{studentId}/{courseId}")
	public ResponseEntity<Student> assignStudentToCourse(@PathVariable Long studentId , @PathVariable Long courseId){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.assignStudentToCourse(studentId, courseId));
	}

}
