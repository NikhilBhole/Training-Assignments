package com.yash.springconfigurationdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.yash.springconfigurationdemo.controller", "com.yash.springconfigurationdemo.serviceimpl", "com.yash.springconfigurationdemo.daoimpl"} )
public class SpringConfiguration {
	
	public SpringConfiguration() {
		System.out.println("SpringConfiguration called....");
	}

}
