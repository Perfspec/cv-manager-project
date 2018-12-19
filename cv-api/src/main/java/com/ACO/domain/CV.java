package com.ACO.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;

	private String cvPath;

	private int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCvPath() {
		return cvPath;
	}

	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}