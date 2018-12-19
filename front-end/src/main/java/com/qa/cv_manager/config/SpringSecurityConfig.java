package com.qa.cv_manager.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qa.constants.Constants;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Value("${database.authentication.query}")
	private String authenticationQuery;
	
	@Value("${database.authorisation.query}")
	private String authorisationQuery;
	
	
    public SpringSecurityConfig() {
        super();
    }
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
     .usersByUsernameQuery(authenticationQuery)
     .authoritiesByUsernameQuery(authorisationQuery);
    } 


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
        	.antMatchers(Constants.REGISTER_PAGE).permitAll()
        	.antMatchers(Constants.TRAINING_MANAGER_PAGES).access(Constants.ROLE_TRAINING_MANAGER)
        	.antMatchers(Constants.TRAINER_PAGES).access(Constants.ROLE_TRAINER)
        	.antMatchers(Constants.TRAINEE_PAGES).access(Constants.ROLE_TRAINEE)
        	.anyRequest().authenticated()
        .and()
        	.formLogin()
        	.loginPage(Constants.LOGIN_PAGE).permitAll()
        	.loginProcessingUrl(Constants.LOGIN)
        	.defaultSuccessUrl(Constants.HOME_PAGE,true)
        	.failureUrl(Constants.LOGIN_ERROR)
        .and()
        	.logout()
        	.logoutUrl(Constants.LOGOUT)
        	.deleteCookies(Constants.SESSION_ID);
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(Constants.CSS_FILES);
		web.ignoring().antMatchers(Constants.JS_FILES);
	}
}