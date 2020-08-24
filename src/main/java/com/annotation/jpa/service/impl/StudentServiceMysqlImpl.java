package com.annotation.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.annotation.jpa.dao.StudentDaoMysql;
import com.annotation.jpa.mapping.beans.Student;
import com.annotation.jpa.service.StudentServiceMysql;

@Component
public class StudentServiceMysqlImpl implements StudentServiceMysql{
    
	@Autowired
	private StudentDaoMysql daosql;
	
	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return daosql.getStudentById(id);
	}

	@Override
	public  List<Student> getStudentByIdAndName(Long id, String starName) {
		// TODO Auto-generated method stub
		return daosql.getStudentByIdAndName(id, starName);
	}

	@Override
	public Student submitStudent(Student student) {
		// TODO Auto-generated method stub
		return daosql.submitStudent(student);
	}

}
