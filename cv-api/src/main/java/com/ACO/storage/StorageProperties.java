package com.ACO.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.ACO.Constants.Constants;

@ConfigurationProperties(Constants.STORAGE_PATH)
public class StorageProperties {

	//Folder location for storing files
	private String location = Constants.STORAGE_DIR;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
