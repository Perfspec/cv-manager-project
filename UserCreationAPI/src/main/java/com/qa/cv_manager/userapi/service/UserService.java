package com.qa.cv_manager.userapi.service;

import org.springframework.http.ResponseEntity;

import com.qa.cv_manager.userapi.persistence.domain.UserPOJO;

public interface UserService {

	ResponseEntity<Object> addUser(UserPOJO user);

	ResponseEntity<Object> updatePassword(UserPOJO user, String username);

	ResponseEntity<Object> deleteUser(String username);

}
