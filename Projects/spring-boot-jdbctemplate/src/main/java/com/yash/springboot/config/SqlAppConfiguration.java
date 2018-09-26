package com.yash.springboot.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.yash.springboot.model")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class SqlAppConfiguration {

	@Value("${spring.datasource.driver-class-name}") String driverClassName;
	@Value("${spring.datasource.url}") String url;
	@Value("${spring.datasource.username}") String username;
	@Value("${spring.datasource.password}") String password;
	
	
	@Bean
	@Autowired
	public DataSource myDatasource() {
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName(driverClassName);
		driverManager.setUrl(url);
		driverManager.setUsername(username);
		driverManager.setPassword(password);
		return driverManager;		
	}
	
	@Bean
	@Autowired
	@Qualifier("myDatasource")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(myDatasource());
		sessionFactoryBean.setPackagesToScan(new String[] {"com.yash.springboot.model"});
		return sessionFactoryBean;
	}
	
	 @Bean
	 @Qualifier("myDatasource")
	 public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		 final DataSourceInitializer initializer = new DataSourceInitializer();
	     initializer.setDataSource(dataSource);
	     return initializer;
	 }
	 
	 @Bean
	 @Autowired
	 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		 HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		 return transactionManager;
	 }
}
