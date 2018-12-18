package com.qa.cv_manager.usercreationapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.qa.cv_manager.usercreationapi.persistence.domain.User;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserEmail;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserRole;
import com.qa.cv_manager.usercreationapi.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public ResponseEntity<Object> addUser(UserPOJO user) {
		if(userExistsInDatabase(user.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		User storedUser = createUserEntityFromPOJO(user);
		
		repo.save(storedUser);
		
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Object> updatePassword(UserPOJO user, String username) {	
		if (!userExistsInDatabase(username)) {
			return ResponseEntity.notFound().build();
		}
		
		User storedUser = createUserEntityFromPOJO(user);
		
		storedUser.setUsername(username);
		repo.save(storedUser);
		
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Object> deleteUser(String username) {
		if(!userExistsInDatabase(username)) {
			return ResponseEntity.notFound().build();
		}
			
		repo.deleteById(username);
		
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Object> disableAccount(String username) {
		return toggleAccount(username, false);
	}
	
	public ResponseEntity<Object> enableAccount(String username) {
		return toggleAccount(username, true);
	}
	
	private ResponseEntity<Object> toggleAccount(String username, boolean isAccountBeingEnabled) {
		if(!userExistsInDatabase(username)) {
			return ResponseEntity.notFound().build();
		}
		
		User disabledUser = repo.findById(username).get();
		disabledUser.setEnabled(isAccountBeingEnabled);
		
		repo.save(disabledUser);
		
		return ResponseEntity.ok().build();
	}
	
	private User createUserEntityFromPOJO(UserPOJO user) {
		UserRole role = new UserRole(user.getUsername(), user.getRole());
		UserEmail email = new UserEmail(user.getUsername(), user.getEmail());
		
		return new User(user.getUsername(),
				passwordEncoder.encode(user.getPassword()),
				user.isEnabled(),
				role, email);
	}
	
	private boolean userExistsInDatabase(String username) {
		return repo.findById(username).isPresent();
	}
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
}
