package com.annotation.jpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class EntityManagerFactoryConfig {
	
    @Autowired
	private Environment environment;
	
	/**
	 * 1.define configuration
	 * 2.get seesionfactory from configuration(sessionfactory is thread safe and immutable)
	 * 3.get session from sessionFactory (session is not threadsafe)
	 * 4.get transaction from session
	 * 5.get query from session
	 */
	
@Bean
public LocalContainerEntityManagerFactoryBean getHibernateConfig() {
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactory=new LocalContainerEntityManagerFactoryBean();//Application context level entitymanager
	Properties properties=new Properties();
	properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");//Dialect version also important based on sqlconnector version
	properties.put("hibernate.hbm2ddl.auto", "update");
	localContainerEntityManagerFactory.setDataSource(getDataSource());
	JpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
	localContainerEntityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
	localContainerEntityManagerFactory.setPackagesToScan("com.annotation.jpa.mapping.beans");
	localContainerEntityManagerFactory.afterPropertiesSet();
	return localContainerEntityManagerFactory;
}

@Bean
public DataSource getDataSource() {
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://db4free.net:3306/vasanthtesting");
	dataSource.setUsername("vasanthkalli");
	dataSource.setPassword("Vasanth@12345");
	return dataSource;
}
}

