package com.qa.cv_manager.usercreationapi;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.cv_manager.usercreationapi.constants.Constants;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidationTests {

	@Autowired
	private Validator validator;
	
	private static final UserPOJO SPECIAL_CHAR_TEST_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.SPECIAL_CHAR_PASSWORD, Constants.SPECIAL_CHAR_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	private static final UserPOJO DIFFERENT_PS_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.MOCK_PASSWORD, Constants.UPDATED_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	private static final UserPOJO SHORT_PS_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.SHORT_PASSWORD, Constants.SHORT_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	private static final UserPOJO NOCAPS_PS_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.NO_CAPS_PASSWORD, Constants.NO_CAPS_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	private static final UserPOJO NONUMBER_PS_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.NO_NUMBER_PASSWORD, Constants.NO_NUMBER_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	
	private static final UserPOJO INVALID_EMAIL_USER1 = new UserPOJO(Constants.MOCK_USERNAME, Constants.MOCK_PASSWORD, Constants.MOCK_PASSWORD, true, Constants.ADMIN, Constants.MOCK_INVALID_EMAIL);
	private static final UserPOJO INVALID_EMAIL_USER2 = new UserPOJO(Constants.MOCK_USERNAME, Constants.MOCK_PASSWORD, Constants.MOCK_PASSWORD, true, Constants.ADMIN, Constants.MOCK_INVALID_EMAIL2);
	private static final UserPOJO VALID_EMAIL_USER = new UserPOJO(Constants.MOCK_USERNAME, Constants.MOCK_PASSWORD, Constants.MOCK_PASSWORD, true, Constants.ADMIN, Constants.MOCK_EMAIL);
	
	@Test
	public void validObjectTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(Constants.TEST_USER_POJO);
		assertEquals(true, violations.isEmpty());
		violations = validator.validate(SPECIAL_CHAR_TEST_USER);
		assertEquals(true, violations.isEmpty());
	}
	
	@Test
	public void passwordMatchesTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(DIFFERENT_PS_USER);
		assertEquals(false, violations.isEmpty());
	}
	
	@Test
	public void passwordLengthTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(SHORT_PS_USER);
		assertEquals(false, violations.isEmpty());
	}
	
	@Test
	public void notEnoughCharTypesTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(NOCAPS_PS_USER);
		assertEquals(false, violations.isEmpty());
		violations = validator.validate(NONUMBER_PS_USER);
		assertEquals(false, violations.isEmpty());
	}
	
	@Test
	public void invalidEmailTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(INVALID_EMAIL_USER1);
		assertEquals(false, violations.isEmpty());
	}
	
	@Test
	public void secondInvalidEmailTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(INVALID_EMAIL_USER2);
		assertEquals(false, violations.isEmpty());
	}
	
	@Test
	public void validEmailTest() {
		Set<ConstraintViolation<UserPOJO>> violations = validator.validate(VALID_EMAIL_USER);
		assertEquals(true, violations.isEmpty());
	}
}
