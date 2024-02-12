package com.learn.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.springboot.dto.DataTransfer;
import com.learn.springboot.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

//	@Query("select new com.learn.springboot.dto.DataTransfer(s.studentName,p.fee) from Student s JOIN on s.courseList p order by p.fee ASC")
//	public List<DataTransfer> getStudentNameAndCourseWithHighestCost();
	
	@Query("SELECT new com.learn.springboot.dto.DataTransfer(s.studentName, p.fee) FROM Student s JOIN s.courseList p ORDER BY s.studentName, p.fee ASC")
	public List<DataTransfer> getStudentNameAndCourseWithHighestCost();
	
	@Query("SELECT new com.learn.springboot.dto.DataTransfer(s.studentName, p.courseName) FROM Student s JOIN s.courseList p ORDER BY s.studentName")
	public List<DataTransfer> getStudentNameAndCourseWithCourseNameAsc();

}
