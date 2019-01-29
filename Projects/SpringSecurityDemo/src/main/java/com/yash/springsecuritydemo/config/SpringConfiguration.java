package com.yash.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.yash.springsecuritydemo")
public class SpringConfiguration implements WebMvcConfigurer {
	
	@Bean  
    public UserDetailsService userDetailsService() throws Exception {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder().username("Nikhil").  
        		password("Nikhil123").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("*").  
                password("*").roles("USER").build());
        return manager;  
    }  
      
	protected void configure(HttpSecurity http) throws Exception {  
        
        http  
        .antMatcher("/")                                 
        .authorizeRequests()  
            .anyRequest().hasRole("ADMIN")  
            .and()  
        .httpBasic();  
    }  
  

}
