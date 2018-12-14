package com.qa.cvapi.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.service.CVService;

@RestController
public class CVEndpoint {

	@Autowired
	private CVService cvService;

	// Get All CVs
	@GetMapping(path = Constants.CV_GET_ALL_EP)
	public @ResponseBody Iterable<CV> getAllCVs() {
		return cvService.getAllCVs();
	}

	// Get a CV
	@GetMapping(path = Constants.CV_GET_CV_EP)
	public Optional<CV> getCV(@PathVariable int id) {
		return cvService.getCV(id);
	}

	// Get CVs
	@GetMapping(path = Constants.CV_GET_CVS_EP)
	public @ResponseBody Iterable<CV> getCVs(@RequestBody Iterable<Integer> ids) {
		return cvService.getCVs(ids);
	}

	// Delete a CV
	@DeleteMapping(path = Constants.CV_DELETE_EP)
	public @ResponseBody String deleteCV(@PathVariable int id) {
		cvService.deleteCV(id);
		return Constants.CV_DELETED;
	}

	// Update a CV
	@PutMapping(path = Constants.CV_UPDATE_EP)
	public @ResponseBody String updateCV(@PathVariable int id, @RequestBody CV cv) {
		cvService.updateCV(id, cv);
		return Constants.CV_UPDATED;
	}

	// Get all Flagged CVs
	@GetMapping(path = Constants.CV_ALL_FLAGGED_EP)
	public @ResponseBody Iterable<CV> getAllFlagged() {
		return cvService.getAllFlagged();
	}

	// Get all Medium Flagged CVs
	@GetMapping(path = Constants.CV_MEDIUM_FLAGGED_EP)
	public @ResponseBody Iterable<CV> getAllMediumFlagged() {
		return cvService.getMediumFlagged();
	}

	// Get all Bad Flagged CVs
	@GetMapping(path = Constants.CV_BAD_FLAGGED_EP)
	public @ResponseBody Iterable<CV> getAllBadFlagged() {
		return cvService.getBadFlagged();
	}

	// Flag/Unflag a CV
	@PutMapping(path = Constants.CV_UPDATE_FLAG)
	public @ResponseBody String updateFlag(@PathVariable int id, @PathVariable int flag) {
		cvService.updateFlag(id, flag);
		return Constants.CV_FLAGGED;
	}
}