package com.soumya.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Long studentId;
	
	@Column(name = "s_name")
	private String studentName;
	
	@Column(name = "s_age")
	private int studentAge;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			    name = "student_course_data",
			    joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "s_id"),
			    inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "c_id")
			
			)

	private List<Course> courses;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourse(Course course) {
		
		this.getCourses().add(course);
	}
	

}
