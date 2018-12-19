package com.ACO.test.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import com.ACO.Constants.Constants;
import com.ACO.domain.CV;

public class CvTest {

	private CV cv;

	@Before
	public void init() {
		cv = Mockito.mock(CV.class);
	}

	@Test
	public void domainTest() {
		String path = Constants.TEST_PATH;

		cv.setCvPath(path);

		when(cv.getCvPath()).thenReturn(Constants.TEST_PATH);

		assertEquals(path, cv.getCvPath());
	}

}
