package com.qa.cv_manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.qa.constants.Constants;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${mysql.database}")
	private String mySqlDatabase;
	
	@Value("${database.username}")
	private String username;
	
	@Value("${database.password}")
	private String password;

	
	public WebConfig() {
        super();
    }

	
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.JS_RESOURCE).addResourceLocations(Constants.STATIC_RESOURCE_LOCATION);
        registry.addResourceHandler(Constants.CSS_RESOURCE).addResourceLocations(Constants.STATIC_RESOURCE_LOCATION);
    }
    
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController(Constants.LOGIN_PAGE);
        registry.addViewController(Constants.HOME_PAGE);
        registry.addViewController(Constants.ADMIN_PAGE);
        registry.addViewController(Constants.TRAINEE_PAGE);
        registry.addViewController(Constants.TRAINER_PAGE);
        registry.addViewController(Constants.ACCESS_DENIED_PAGE);
        registry.addViewController(Constants.REGISTER_PAGE);
    }
    
    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix (Constants.FOLDER_PREFIX);
        resolver.setSuffix (Constants.PAGE_SUFFIX);
        resolver.setViewClass (JstlView.class);
        return resolver;
    }
    
    @Bean(name = Constants.DATA_SOURCE)
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(mySqlDatabase);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }
    
    
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
