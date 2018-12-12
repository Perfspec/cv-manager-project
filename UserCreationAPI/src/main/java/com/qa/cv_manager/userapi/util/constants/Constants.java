package com.qa.cv_manager.userapi.util.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.cv_manager.userapi.persistence.domain.User;
import com.qa.cv_manager.userapi.persistence.domain.UserPOJO;
import com.qa.cv_manager.userapi.persistence.domain.UserRole;

public class Constants {
	
	private Constants() {}	
	
	public static final String PASSWORD_MATCHES_ERROR = "Passwords don't match";
	public static final String INVALID_PASSWORD_ERROR = "Invalid Password";

	//Testing
	public static final String MOCK_USERNAME = "MOCK_USER";
	public static final String MOCK_PASSWORD = "Password1";
	public static final String UPDATED_PASSWORD = "Password2";
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String SHORT_PASSWORD = "Passwo1";
	public static final String SPECIAL_CHAR_PASSWORD = "password1.";
	public static final String NO_CAPS_PASSWORD = "password1";
	public static final String NO_NUMBER_PASSWORD = "Password";
	
	public static final UserPOJO TEST_USER_POJO = new UserPOJO(MOCK_USERNAME, MOCK_PASSWORD, MOCK_PASSWORD, true, ADMIN);
	public static final UserPOJO UPDATED_TEST_USER_POJO = new UserPOJO(Constants.MOCK_USERNAME, UPDATED_PASSWORD, UPDATED_PASSWORD, true, ADMIN);
	public static final UserRole MOCK_USER_ROLE = new UserRole(MOCK_USERNAME, ADMIN);
	public static final User MOCK_USER = new User(MOCK_USERNAME, MOCK_PASSWORD, true, MOCK_USER_ROLE);
	
	public static final ResponseEntity<Object> RESPONSE_OK = new ResponseEntity<>(HttpStatus.OK);
	public static final ResponseEntity<Object> RESPONSE_NOT_FOUND = new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
