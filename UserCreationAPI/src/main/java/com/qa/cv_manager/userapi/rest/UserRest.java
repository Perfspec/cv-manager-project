package com.qa.cv_manager.userapi.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cv_manager.userapi.persistence.domain.UserPOJO;
import com.qa.cv_manager.userapi.service.UserService;

@RestController
public class UserRest {

	@Autowired
	private UserService service;
	
	@PostMapping("${path.addUser}")
	public ResponseEntity<Object> addUser(@RequestBody @Valid UserPOJO user) {
		return service.addUser(user);
	}
	
	@PutMapping("${path.updatePassword}")
	public ResponseEntity<Object> updatePassword(@RequestBody @Valid UserPOJO user, @PathVariable String username) {
		return service.updatePassword(user, username);
	}
	
	@DeleteMapping("${path.deleteUser}")
	public ResponseEntity<Object> deleteUser(@PathVariable String username) {
		return service.deleteUser(username);
	}
}
