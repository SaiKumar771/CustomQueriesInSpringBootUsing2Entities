package com.learn.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.dto.DataTransfer;
import com.learn.springboot.entity.Student;
import com.learn.springboot.exception.StudentDataNotFoundException;
import com.learn.springboot.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository studentRepo;

	@Override
	public Student addStudent(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	@Override
	public Student getStudent(int id) {

		return studentRepo.getReferenceById(id);
	}

	@Override
	public Student updateStudent(int id) {

		Student updateStudent = studentRepo.findById(id).orElseThrow(()->new StudentDataNotFoundException("Student not exists with these id:"+id));

		return studentRepo.save(updateStudent);
	}

	@Override
	public void deleteStudent(int id) {

		studentRepo.deleteById(id);
	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepo.findAll();
	}

	public void deleteAll()
	{
		studentRepo.deleteAll();
	}

	@Override
	public List<DataTransfer> getStudentNameAndCourseWithHighestCost() {
		
		return studentRepo.getStudentNameAndCourseWithHighestCost();
	}

	@Override
	public List<DataTransfer> getStudentNameAndCourseWithCourseNameAsc() {
		
		return studentRepo.getStudentNameAndCourseWithCourseNameAsc();
	}
}
