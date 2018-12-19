package com.ACO.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	//initialises storage
	void init();

	void store(MultipartFile file);

	//loads all from storage
	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

}
