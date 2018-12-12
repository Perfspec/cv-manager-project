package com.qa.cv_manager.userapi.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String username;

	private String password;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private UserRole role;
	
	public User() {}
	
	public User(String username, String password, boolean enabled, UserRole role) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String toString() {
		return username + enabled + role.toString();
	}
}
