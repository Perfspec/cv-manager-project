package com.qa.cvapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.persistence.repository.CVRepository;

public class ServiceTest {

	private CV cv;
	private CVService service;
	private CVRepository repo;

	@Before
	public void init() {
		cv = Mockito.mock(CV.class);
		service = Mockito.mock(CVService.class);
		repo = Mockito.mock(CVRepository.class);
	}

	@Test
	public void createCV() {
		cv.setId(1);
		cv.setCvPath(Constants.TEST_PATH);
		service.addCV(cv);

		when(repo.count()).thenReturn(1l);

		Long actual = repo.count();
		Long expected = 1l;

		assertEquals(expected, actual);
	}

	@Test
	public void updateCV() {
		CV newCV = new CV();
		cv.setId(1);
		service.updateCV(1, newCV);

		when(service.updateCV(1, newCV)).thenReturn(newCV);

		assertEquals(newCV, service.updateCV(1, newCV));
	}

	@Test
	public void deleteCV() {
		cv.setId(1);
		service.deleteCV(1);

		when(service.deleteCV(1)).thenReturn(Constants.CV_DELETED);

		String expected = Constants.CV_DELETED;

		assertEquals(expected, service.deleteCV(1));
	}

}
