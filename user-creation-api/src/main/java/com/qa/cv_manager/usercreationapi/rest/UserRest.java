package com.qa.cv_manager.usercreationapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cv_manager.usercreationapi.persistence.domain.User;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;
import com.qa.cv_manager.usercreationapi.service.UserService;

@RestController
public class UserRest {

	@Autowired
	private UserService service;
	
	@GetMapping("${path.getAll}")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@PostMapping("${path.addUser}")
	public ResponseEntity<Object> addUser(@RequestBody @Valid UserPOJO user) {
		return service.addUser(user);
	}
	
	@PutMapping("${path.updatePassword}")
	@PreAuthorize("#username == authentication.principal.username || hasAnyRole('TRAINING_MANAGER', 'TRAINER')")
	public ResponseEntity<Object> updatePassword(@RequestBody @Valid UserPOJO user, @PathVariable String username) {
		return service.updatePassword(user, username);
	}
	
	@DeleteMapping("${path.deleteUser}")
	@PreAuthorize("#username == authentication.principal.username || hasRole('TRAINING_MANAGER')")
	public ResponseEntity<Object> deleteUser(@PathVariable String username) {
		return service.deleteUser(username);
	}
	
	@PutMapping("${path.disableAccount}")
	public ResponseEntity<Object> disableAccount(@PathVariable String username) {
		return service.disableAccount(username);
	}
	
	@PutMapping("${path.enableAccount}")
	public ResponseEntity<Object> enableAccount(@PathVariable String username) {
		return service.enableAccount(username);
	}
	
	
}
