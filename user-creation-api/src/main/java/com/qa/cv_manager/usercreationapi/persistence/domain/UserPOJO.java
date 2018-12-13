package com.qa.cv_manager.usercreationapi.persistence.domain;

import com.qa.cv_manager.usercreationapi.validation.PasswordMatches;
import com.qa.cv_manager.usercreationapi.validation.ValidPassword;

@PasswordMatches
public class UserPOJO {
	
	private String username;

	@ValidPassword
	private String password;
	
	private String confirmPassword;
	
	private boolean enabled;
	
	private String role;
	
	public UserPOJO() {}
	
	public UserPOJO(String username, String password, String confirmPassword, boolean enabled, String role) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = enabled;
		this.role = role;
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
}
