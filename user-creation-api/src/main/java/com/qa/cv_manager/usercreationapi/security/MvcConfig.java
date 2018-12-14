package com.qa.cv_manager.usercreationapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MvcConfig {
	
	@Value("${spring.datasource.url}")
	private String dataSourceURL;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	@Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
    	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    	driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	driverManagerDataSource.setUrl(dataSourceURL);
    	driverManagerDataSource.setUsername(username);
    	driverManagerDataSource.setPassword(password);
    	return driverManagerDataSource;
    }
}