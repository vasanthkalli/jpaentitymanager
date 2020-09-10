package com.annotation.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.annotation.jpa.dao.UserDao;
import com.annotation.jpa.mapping.beans.User;
@Component
public class UserDaoImpl implements UserDao{
    
	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public User getUserDetails(String userName) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		User user=entityManager.find(User.class, String.class);
		return user;
	}

	@Override
	public String saveUserDetails(User user) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		return "user Saved";
	}

}
