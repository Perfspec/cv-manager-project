package com.ACO.service;

import java.util.Optional;

import com.ACO.domain.CV;

public interface ICVService {

	// CV methods

	public CV addCV(CV cv);

	public Iterable<CV> getAllCVs();

	public CV updateCV(int id, CV cv);

	public String deleteCV(int id);

	public Optional<CV> getCV(int id);

	// Flag methods

	public Iterable<CV> getAllFlagged();

	public Iterable<CV> getMediumFlagged();

	public Iterable<CV> getBadFlagged();

	public CV updateFlag(int id, int flag);
}
