package com.qa.cv_manager.usercreationapi.service;

import org.springframework.http.ResponseEntity;

import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;

public interface UserService {

	ResponseEntity<Object> addUser(UserPOJO user);

	ResponseEntity<Object> updatePassword(UserPOJO user, String username);

	ResponseEntity<Object> deleteUser(String username);

	ResponseEntity<Object> disableAccount(String username);

	ResponseEntity<Object> enableAccount(String username);
}
