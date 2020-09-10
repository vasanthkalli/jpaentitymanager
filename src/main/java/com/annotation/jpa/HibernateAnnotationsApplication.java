package com.annotation.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
//datasource vs sesssionfactory vs connection pooling --tomo
public class HibernateAnnotationsApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("password"));
		SpringApplication.run(HibernateAnnotationsApplication.class, args);

	}

}
