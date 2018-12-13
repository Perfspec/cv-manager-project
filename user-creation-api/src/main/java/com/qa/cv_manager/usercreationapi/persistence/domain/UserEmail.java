package com.qa.cv_manager.usercreationapi.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_emails")
public class UserEmail {

	@Id
	private String username;

	private String email;
	
	public UserEmail() {}
	
	public UserEmail(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
