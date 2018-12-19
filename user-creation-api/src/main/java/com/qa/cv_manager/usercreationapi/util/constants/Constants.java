package com.qa.cv_manager.usercreationapi.util.constants;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.cv_manager.usercreationapi.persistence.domain.User;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserEmail;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserRole;

public class Constants {
	
	private Constants() {}	
	
	public static final String PASSWORD_MATCHES_ERROR = "Passwords don't match";
	public static final String INVALID_PASSWORD_ERROR = "Invalid Password";
	public static final String INVALID_EMAIL_ERROR = "Invalid E-mail address";
	
	public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	//Testing
	public static final String MOCK_USERNAME = "MOCK_USER";
	public static final String ANOTHER_MOCK_USERNAME = "ANOTHER_MOCK_USER";
	public static final String MOCK_PASSWORD = "Password1";
	public static final String UPDATED_PASSWORD = "Password2";
	public static final String ADMIN = "ROLE_TRAINING_MANAGER";
	public static final String USER = "ROLE_TRAINEE";
	public static final String SHORT_PASSWORD = "Passwo1";
	public static final String SPECIAL_CHAR_PASSWORD = "password1.";
	public static final String NO_CAPS_PASSWORD = "password1";
	public static final String NO_NUMBER_PASSWORD = "Password";
	public static final String MOCK_EMAIL = "validemail@gmail.com";
	public static final String MOCK_INVALID_EMAIL = "ben@.test.com";
	public static final String MOCK_INVALID_EMAIL2 = "ben@test.co.co,m";
	
	public static final UserPOJO TEST_USER_POJO = new UserPOJO(MOCK_USERNAME, MOCK_PASSWORD, MOCK_PASSWORD, true, ADMIN, MOCK_EMAIL);
	public static final UserPOJO UPDATED_TEST_USER_POJO = new UserPOJO(Constants.MOCK_USERNAME, UPDATED_PASSWORD, UPDATED_PASSWORD, true, ADMIN, MOCK_EMAIL);
	public static final UserRole MOCK_USER_ROLE = new UserRole(MOCK_USERNAME, ADMIN);
	public static final UserEmail MOCK_USER_EMAIL = new UserEmail(MOCK_USERNAME, MOCK_EMAIL);
	public static final User MOCK_USER = new User(MOCK_USERNAME, MOCK_PASSWORD, true, MOCK_USER_ROLE, MOCK_USER_EMAIL);
	public static final List<User> MOCK_LIST = Arrays.asList(MOCK_USER);
	
	public static final ResponseEntity<Object> RESPONSE_OK = new ResponseEntity<>(HttpStatus.OK);
	public static final ResponseEntity<Object> RESPONSE_NOT_FOUND = new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
