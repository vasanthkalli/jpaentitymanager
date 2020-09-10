package com.annotation.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.annotation.jpa.dao.UserDao;
import com.annotation.jpa.mapping.beans.User;
import com.annotation.jpa.request.UserDetailsImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
   
	@Autowired
	private UserDao userDao;
	
	public UserDetails loadUserByUsername(String username) {
		
		User user=userDao.getUserDetails(username);
		return new UserDetailsImpl(user);
	}
	
}
