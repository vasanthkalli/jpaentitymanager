package com.annotation.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.annotation.jpa.mapping.beans.Student;

@Repository
public interface StudentDaoMysql {

   public Student getStudentById(Long id);
	
	public  List<Student> getStudentByIdAndName(Long id,String starName);
	
	public Student submitStudent(Student student);
}
