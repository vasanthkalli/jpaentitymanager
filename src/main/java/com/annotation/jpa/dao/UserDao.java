package com.annotation.jpa.dao;

import org.springframework.stereotype.Repository;

import com.annotation.jpa.mapping.beans.User;

@Repository
public interface UserDao {

	public User getUserDetails(String userName);
	
	public String saveUserDetails(User user);
}
