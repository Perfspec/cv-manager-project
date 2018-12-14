package com.qa.cv_manager.usercreationapi;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qa.cv_manager.usercreationapi.constants.Constants;
import com.qa.cv_manager.usercreationapi.persistence.repository.UserRepository;
import com.qa.cv_manager.usercreationapi.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTests {

	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repo;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void addUserTest() {
		Mockito.when(repo.save(Mockito.any())).thenReturn(Constants.MOCK_USER);
		Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn(Constants.MOCK_PASSWORD);
		assertEquals(Constants.RESPONSE_OK, service.addUser(Constants.TEST_USER_POJO));
		Mockito.verify(repo).save(Mockito.any());
	}
	
	@Test
	public void updatePasswordTest() {
		Mockito.when(repo.findById(Constants.MOCK_USERNAME)).thenReturn(Optional.of(Constants.MOCK_USER));
		Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn(Constants.MOCK_PASSWORD);
		assertEquals(Constants.RESPONSE_OK, service.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME));
		Mockito.verify(repo).findById(Constants.MOCK_USERNAME);
	}
	
	@Test
	public void updatePasswordNotFoundTest() {
		Mockito.when(repo.findById(Constants.MOCK_USERNAME)).thenReturn(Optional.empty());
		assertEquals(Constants.RESPONSE_NOT_FOUND, service.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME));
		Mockito.verify(repo).findById(Constants.MOCK_USERNAME);
	}
	
	@Test
	public void deleteUserTest() {
		Mockito.when(repo.findById(Constants.MOCK_USERNAME)).thenReturn(Optional.of(Constants.MOCK_USER));
		assertEquals(Constants.RESPONSE_OK, service.deleteUser(Constants.MOCK_USERNAME));
		Mockito.verify(repo).findById(Constants.MOCK_USERNAME);
	}
	
	@Test
	public void deleteUserNotFoundTest() {
		Mockito.when(repo.findById(Constants.MOCK_USERNAME)).thenReturn(Optional.empty());
		assertEquals(Constants.RESPONSE_NOT_FOUND, service.deleteUser(Constants.MOCK_USERNAME));
		Mockito.verify(repo).findById(Constants.MOCK_USERNAME);
	}
}
