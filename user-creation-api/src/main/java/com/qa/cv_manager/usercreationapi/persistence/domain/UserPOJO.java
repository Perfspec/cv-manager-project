package com.qa.cv_manager.usercreationapi.persistence.domain;

import com.qa.cv_manager.usercreationapi.util.validation.PasswordMatches;
import com.qa.cv_manager.usercreationapi.util.validation.ValidEmail;
import com.qa.cv_manager.usercreationapi.util.validation.ValidPassword;

@PasswordMatches
public class UserPOJO {
	
	private String username;

	@ValidPassword
	private String password;
	
	private String confirmPassword;
	
	private boolean enabled;
	
	private String role;
	
	@ValidEmail
	private String email;
	
	public UserPOJO() {}
	
	public UserPOJO(String username, String password, String confirmPassword, boolean enabled, String role, String email) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = enabled;
		this.role = role;
		this.email = email;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return username + enabled + role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
