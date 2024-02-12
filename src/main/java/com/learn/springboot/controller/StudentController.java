package com.learn.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.dto.DataTransfer;
import com.learn.springboot.entity.Student;
import com.learn.springboot.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping("/add")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/students/get/{id}")
	public Student getStudent(@PathVariable int id) {

		return studentService.getStudent(id);
	}

	@PutMapping("/change/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

		Student update = studentService.getStudent(id);
		update.setId(student.getId());
		update.setStudentName(student.getStudentName());
		update.setEmail(student.getEmail());
		update.setCourseList(student.getCourseList());

		return studentService.updateStudent(id);
	}

	@DeleteMapping("/remove/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "Student Deleted";
	}

	@GetMapping("/students/all")
	public List<Student> getAllStudent() {

		return studentService.getAllStudent();
	}

	@DeleteMapping("/remove/all")
	public void deleteAllStudents() {
		studentService.deleteAll();
	}

	@GetMapping("/custom/order")
	public List<DataTransfer> getStudentNameAndCourseWithHighestCost() {
		return studentService.getStudentNameAndCourseWithHighestCost();
	}

	@GetMapping("/custom/order/list")
	public List<DataTransfer> getStudentNameAndCourseWithCourseNameAsc() {

		return studentService.getStudentNameAndCourseWithCourseNameAsc();
	}
}
