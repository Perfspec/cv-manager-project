package com.qa.cvapi.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.qa.cvapi.constants.Constants;

@Service
public class FileSystemStorageService implements StorageService {

	private final Path rootLocation;

	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void store(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			checkFileType(file, filename);
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new StorageException(Constants.STORAGE_FILE_FAIL + filename, e);
		}
	}
	
	private void checkFileType(MultipartFile file, String filename) throws StorageException {
		if (file.isEmpty()) {
			throw new StorageException(Constants.STORAGE_FAIL_EMPTY + filename);
		}
		if (filename.contains("..")) {
			// This is a security check
			throw new StorageException(
					Constants.STORAGE_PATH_FAIL + filename);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation))
					.map(this.rootLocation::relativize);
		} catch (IOException e) {
			throw new StorageException(Constants.STORAGE_FAIL_TO_READ, e);
		}
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				Path file2 = load(Constants.DEFAULT_FILE);
				return new UrlResource(file2.toUri());
			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException(Constants.STORAGE_COULD_NOT_READ + filename, e);
		}
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException(Constants.STORAGE_COULD_NOT_INITIALISE, e);
		}
	}
}
