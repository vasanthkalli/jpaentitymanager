package com.annotation.jpa.mapping.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = {"username"} ))
public class User {
	
	@Size(min=3,max=10,message="username must be 3 to 10 char length")
    @NotBlank(message="username must not be null")
	@Column(name="username")
	@Id
	private String username;
	@Size(min=3,max=10,message="username must be 3 to 10 char length")
	@NotBlank(message="password canot be null")
	@Column(name="password")
	private String password;
	@Column(name="authorities")
	@ElementCollection
	//For saving basic collection
	private List<String> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List authorities) {
		this.authorities = authorities;
	}
	
	
}
