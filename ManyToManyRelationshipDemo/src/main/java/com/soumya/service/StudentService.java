package com.soumya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.entity.Course;
import com.soumya.entity.Student;
import com.soumya.exception.AssignmentFailureException;
import com.soumya.exception.StudentNotFoundException;
import com.soumya.repository.CourseRepository;
import com.soumya.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){
		
		return studentRepository.findAll();
	}
	
	public Student findStudentById(Long id) { 
		
		return this.studentRepository.
				    findById(id).
				    orElseThrow(() -> StudentNotFoundException.
				    		          builder().
				    		          message("Student not found with id : "+id).
				    		          build());
	}
	
	public Student assignStudentToCourse(Long studentId,Long courseId) {
		
		Student student = studentRepository.findById(studentId).orElse(null);
		Course course = courseRepository.findById(courseId).orElse(null);
	
		
		if(student != null && course != null) {
			
			student.setCourse(course);
			studentRepository.save(student);
			return student;
		}
		
		throw AssignmentFailureException.
			  builder().
			  message("Invalid student/project id !! ").
			  build();
		
		
	}

}
