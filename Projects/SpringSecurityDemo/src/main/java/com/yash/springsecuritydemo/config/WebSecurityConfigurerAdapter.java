package com.yash.springsecuritydemo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {  
		http  
		.authorizeRequests()  
		.anyRequest().authenticated()  
		.and()  
		.formLogin()  
		.and()  
		.httpBasic();  
		}  
}
