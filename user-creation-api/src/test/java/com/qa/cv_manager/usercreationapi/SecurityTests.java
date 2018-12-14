package com.qa.cv_manager.usercreationapi;

import java.nio.file.AccessDeniedException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.cv_manager.usercreationapi.rest.UserRest;
import com.qa.cv_manager.usercreationapi.util.constants.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTests {
	
	@Autowired
	private UserRest rest;
	
	@Test
	@WithMockUser(authorities = Constants.ADMIN)
	public void adminUpdateAccountTest() {
		rest.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME);
	}
	
	@Test
	@WithMockUser(authorities = Constants.USER, value = Constants.MOCK_USERNAME)
	public void selfUpdateAccountTest() {
		rest.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME);
	}
	
	@Test(expected = AccessDeniedException.class)
	@WithMockUser(authorities = Constants.USER, value = Constants.ANOTHER_MOCK_USERNAME)
	public void userUpdateAccountTest() {
		rest.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME);
	}
	
	@Test
	@WithMockUser(authorities = Constants.ADMIN)
	public void adminDeleteAccountTest() {
		rest.deleteUser(Constants.MOCK_USERNAME);
	}
	
	@Test
	@WithMockUser(authorities = Constants.USER, value = Constants.MOCK_USERNAME)
	public void selfDeleteAccountTest() {
		rest.deleteUser(Constants.MOCK_USERNAME);
	}
	
	@Test(expected = AccessDeniedException.class)
	@WithMockUser(authorities = Constants.USER, value = Constants.ANOTHER_MOCK_USERNAME)
	public void userDeleteAccountTest() {
		rest.deleteUser(Constants.MOCK_USERNAME);
	}
}