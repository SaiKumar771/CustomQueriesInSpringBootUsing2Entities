package com.learn.springboot.service;

import java.util.List;

import com.learn.springboot.dto.DataTransfer;
import com.learn.springboot.entity.Student;

public interface IStudentService {

	public Student addStudent(Student student);
	
	public Student getStudent(int id);
	
	public Student updateStudent(int id);
	
	public void deleteStudent(int id);
	
	public List<Student> getAllStudent();
	
	public void deleteAll();
	
	public List<DataTransfer> getStudentNameAndCourseWithHighestCost();
	
	public List<DataTransfer> getStudentNameAndCourseWithCourseNameAsc();
}
