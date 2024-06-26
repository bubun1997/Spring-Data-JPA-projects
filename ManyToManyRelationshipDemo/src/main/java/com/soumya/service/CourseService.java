package com.soumya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.entity.Course;
import com.soumya.exception.CourseNotFoundException;
import com.soumya.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public Course addCourse(Course course) {
		
		return this.courseRepository.save(course);
	}
	
	public List<Course> getAllCourses(){
		
		return this.courseRepository.findAll();
	}
	
	public Course getCourseById(Long id) {
		
		return this.courseRepository.
				    findById(id).
				    orElseThrow(() -> CourseNotFoundException.
				    		          builder().
				    		          message("Course not found with id : "+id).
				    		          build());
	}
	
	

}
