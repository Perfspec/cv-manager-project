package com.qa.cvapi.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.persistence.repository.CVRepository;

@Service
public class CVService implements ICVService {

	@Autowired
	private CVRepository cvRepo;

	// Create CV
	public CV addCV(CV cv) {
		return cvRepo.save(cv);
	}

	// Read all CVs
	public Iterable<CV> getAllCVs() {
		return cvRepo.findAll();
	}

	// Update CV
	public CV updateCV(int id, CV cv) {
		Optional<CV> cvInDB = cvRepo.findById(id);

		cvInDB.get().setCvPath(cv.getCvPath());

		cvInDB.get().setFlag(cv.getFlag());

		cvRepo.save(cvInDB.get());

		return cvInDB.get();
	}

	// Delete CV
	public String deleteCV(int id) {
		cvRepo.deleteById(id);
		return Constants.CV_DELETED;
	}

	// Get individual CV
	public Optional<CV> getCV(int id) {
		return cvRepo.findById(id);
	}

	// Flag/Unflag a CV
	public CV updateFlag(int id, int flag) {
		if (flag > 2) {
			flag = 2;
		} else if (flag < 0) {
			flag = 0;
		}

		Optional<CV> cvInDB = cvRepo.findById(id);

		cvInDB.get().setFlag(flag);

		cvRepo.save(cvInDB.get());

		return cvInDB.get();
	}

	// Get all Flagged CVs
	public Iterable<CV> getAllFlagged() {
		return getListBy(cv -> cv.getFlag() > 0);
	}

	// Get all Medium Flagged CVs
	public Iterable<CV> getMediumFlagged() {
		return getListBy(cv -> cv.getFlag() == 1);
	}

	// Get all Bad Flagged CVs
	public Iterable<CV> getBadFlagged() {
		return getListBy(cv -> cv.getFlag() == 2);
	}
	
	public Iterable<CV> getListBy(Predicate<CV> filterPredicate) {
		Iterable<CV> filteredList = new ArrayList<CV>();
		Iterable<CV> cvList = cvRepo.findAll();

		filteredList = StreamSupport.stream(cvList.spliterator(), false).filter(filterPredicate)
				.collect(Collectors.toList());

		return filteredList;
	}

}
