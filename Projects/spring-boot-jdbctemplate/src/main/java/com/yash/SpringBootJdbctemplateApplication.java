package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springboot.config.SpringConfiguration;

@SpringBootApplication(exclude= {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringBootJdbctemplateApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SpringBootJdbctemplateApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbctemplateApplication.class, args);
	//	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	
}
