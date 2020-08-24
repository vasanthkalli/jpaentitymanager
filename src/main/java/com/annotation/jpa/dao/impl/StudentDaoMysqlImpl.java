package com.annotation.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.annotation.jpa.dao.StudentDaoMysql;
import com.annotation.jpa.mapping.beans.Student;


@Component
public class StudentDaoMysqlImpl implements StudentDaoMysql{
    
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Student getStudentById(Long id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		//Student student=entityManager.load(Student.class, id);//Here we need to see the difference between load and get
		Student student=entityManager.find(Student.class, id);
		entityManager.getTransaction().commit();//we need to see the states of objects in hibernate
		entityManager.close();
		return student;
	}

	@Override
	public List<Student> getStudentByIdAndName(Long id, String starName) {
		//begin transaction even for read operations .recommented 
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("FROM student s WHERE s.id=:student_id");
		query.setParameter("student_id", id);
		List<Student> result=query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	@Override
	public Student submitStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
		return student;
	}
	

}
