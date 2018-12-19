package com.qa.cvapi.persistence.domain;

public class CV {

	private int id;

	private String cvPath;

	private int flag;
	
	public CV() {}
	
	public CV(int id, String cvPath, int flag) {
		this.id = id;
		this.cvPath = cvPath;
		this.flag = flag;
	}

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
}