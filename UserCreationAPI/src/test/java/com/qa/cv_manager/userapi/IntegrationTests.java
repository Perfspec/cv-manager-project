package com.qa.cv_manager.userapi;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.cv_manager.userapi.persistence.domain.User;
import com.qa.cv_manager.userapi.persistence.repository.UserRepository;
import com.qa.cv_manager.userapi.rest.UserRest;
import com.qa.cv_manager.userapi.util.constants.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

	@Autowired
	private UserRest rest;
	
	@Autowired
	private UserRepository repo;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private static final User UPDATED_TEST_USER = new User(Constants.MOCK_USERNAME, Constants.UPDATED_PASSWORD, true, Constants.MOCK_USER_ROLE);
	
	@Test
	public void addUserTest() {
		rest.addUser(Constants.TEST_USER_POJO);
		assertEquals(Constants.MOCK_USER.toString(), repo.findById(Constants.MOCK_USERNAME).get().toString());
		assertEquals(true, passwordEncoder.matches(Constants.MOCK_PASSWORD, repo.findById(Constants.MOCK_USERNAME).get().getPassword()));
	}
	
	@Test
	public void updatePasswordTest() {
		rest.updatePassword(Constants.UPDATED_TEST_USER_POJO, Constants.MOCK_USERNAME);
		assertEquals(UPDATED_TEST_USER.toString(), repo.findById(Constants.MOCK_USERNAME).get().toString());
		assertEquals(true, passwordEncoder.matches(Constants.UPDATED_PASSWORD, repo.findById(Constants.MOCK_USERNAME).get().getPassword()));
	}
	
	@Test
	public void deleteUserTest() {
		rest.deleteUser(Constants.MOCK_USERNAME);
		assertEquals(Optional.empty(), repo.findById(Constants.MOCK_USERNAME));
	}
}
