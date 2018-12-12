package com.qa.cvapi.rest;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.persistence.repository.CVRepository;
import com.qa.cvapi.storage.StorageFileNotFoundException;
import com.qa.cvapi.storage.StorageService;

@RestController
public class CVUploadEndpoint {

	private final StorageService storageService;

	@Autowired
	public CVUploadEndpoint(StorageService storageService) {
		this.storageService = storageService;
	}

	@Autowired
	private CVRepository cvRepo;

	//List all added CVs
	@GetMapping(Constants.CV_ADD)
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files",
				storageService.loadAll()
						.map(path -> MvcUriComponentsBuilder
								.fromMethodName(CVUploadEndpoint.class, "serveFile", path.getFileName().toString())
								.build().toString())
						.collect(Collectors.toList()));
		return "uploadForm";
	}

	@GetMapping(Constants.CV_URL)
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	//Add a new CV
	@PostMapping(Constants.CV_ADD)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			CV cv) {

		storageService.store(file);
		cv.setCvPath(Constants.CV_FILES_PATH + file.getOriginalFilename());
		cv.setFlag(0);
		cvRepo.save(cv);
		redirectAttributes.addFlashAttribute("message",
				Constants.CV_SUCCESSFUL + file.getOriginalFilename() + "!");

		return Constants.CV_REDIRECT;
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}