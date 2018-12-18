package com.qa.cvapi.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.persistence.repository.CVRepository;

@Service
public class CVService implements ICVService {

	@Autowired
	private CVRepository cvRepo;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.saveCV}")
	private String cvQueue;

	public CV addCV(CV cv) {
		jmsTemplate.convertAndSend(cvQueue, cv);
		return cvRepo.save(cv);
	}

	public Iterable<CV> getAllCVs() {
		return cvRepo.findAll();
	}

	public Optional<CV> getCV(int id) {
		return cvRepo.findById(id);
	}
	
	public Iterable<CV> getCVs(Iterable<Integer> ids) {
		return cvRepo.findAllById(ids);
	}

	public CV updateCV(int id, CV cv) {
		Optional<CV> cvInDB = cvRepo.findById(id);

		cvInDB.get().setCvPath(cv.getCvPath());

		cvInDB.get().setFlag(cv.getFlag());

		cvRepo.save(cvInDB.get());

		return cvInDB.get();
	}

	public String deleteCV(int id) {
		cvRepo.deleteById(id);
		return Constants.CV_DELETED;
	}

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

	public Iterable<CV> getAllFlagged() {
		return getListBy(cv -> cv.getFlag() > 0);
	}

	public Iterable<CV> getMediumFlagged() {
		return getListBy(cv -> cv.getFlag() == 1);
	}
	
	public Iterable<CV> getBadFlagged() {
		return getListBy(cv -> cv.getFlag() == 2);
	}

	private Iterable<CV> getListBy(Predicate<CV> filterPredicate) {
		Iterable<CV> filteredList = new ArrayList<CV>();
		Iterable<CV> cvList = cvRepo.findAll();

		filteredList = StreamSupport.stream(cvList.spliterator(), false).filter(filterPredicate)
				.collect(Collectors.toList());

		return filteredList;
	}
}
