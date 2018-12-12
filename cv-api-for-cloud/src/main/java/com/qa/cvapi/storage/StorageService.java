package com.qa.cvapi.storage;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	//initialises storage
	void init();

	void store(MultipartFile file);

	//loads all from storage
	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

}