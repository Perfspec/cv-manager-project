package com.qa.constants;

public class Constants {
	public static final String SERVLET_DISPATCHER = "dispatcher";
	public static final String ROOT_PAGE = "/";
	
	public static final String DATA_SOURCE = "datasource";
	
	public static final String LOGIN_PAGE = "/login";
	public static final String REGISTER_PAGE = "/register";
	public static final String HOME_PAGE = "/homepage";
	public static final String ADMIN_PAGE = "/admin/home";
	public static final String TRAINER_PAGE = "/trainer/home";
	public static final String TRAINEE_PAGE = "/trainee/home";
	public static final String ACCESS_DENIED_PAGE = "error/accessDenied";
	
	public static final String CSS_RESOURCE = "/*.css/**";
	public static final String JS_RESOURCE = "/*.js/**";
	public static final String STATIC_RESOURCE_LOCATION = "/ui/static/";
	
	public static final String FOLDER_PREFIX = "/ui/jsp/";
	public static final String PAGE_SUFFIX = ".jsp";

	public static final String TRAINING_MANAGER_PAGES ="/admin/**";
	public static final String TRAINER_PAGES ="/trainer/**";
	public static final String TRAINEE_PAGES ="/trainee/**";
	public static final String LOGIN ="/perform_login";
	public static final String LOGIN_ERROR ="/login?error=true";
	public static final String LOGOUT ="/perform_logout";
	public static final String SESSION_ID ="JSESSIONID";
	
	public static final String ROLE_TRAINING_MANAGER ="hasRole('ROLE_TRAINING_MANAGER')";
	public static final String ROLE_TRAINER ="hasRole('ROLE_TRAINER')";
	public static final String ROLE_TRAINEE ="hasRole('ROLE_TRAINEE')";

	public static final String CSS_FILES = "/*.css";
	public static final String JS_FILES = "/*.js";
	
}
