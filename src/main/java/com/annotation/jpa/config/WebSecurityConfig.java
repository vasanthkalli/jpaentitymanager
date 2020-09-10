package com.annotation.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
    
    @Autowired
    private AuthenticationEntryPoint authenticationEntrypoint;
    
    @Value("${auth.username}")
    private String username;
    
    @Value("${auth.password}")
    private String password;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/users").permitAll()
		.antMatchers("/student/**").hasRole("USER")
		.anyRequest().authenticated()
		.and().httpBasic().authenticationEntryPoint(authenticationEntrypoint)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	}
	
	//when we autowire the method the parameters are autowired
//   @Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
//		authBuilder.inMemoryAuthentication().withUser(username).password("{noop}"+password).roles("USER");
//	}
    
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
	.withUser(username).password(password).roles("USER");
}
   
 @Bean 
 public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
