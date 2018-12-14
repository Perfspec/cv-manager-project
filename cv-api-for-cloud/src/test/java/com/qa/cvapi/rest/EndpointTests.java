package com.qa.cvapi.rest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.service.CVService;

@RunWith(MockitoJUnitRunner.class)
public class EndpointTests {
	
	@InjectMocks
	private CVEndpoint rest;
	
	@Mock
	private CVService service;
	
	@Mock
	private CV cv;
	
	@Before
	public void init() {
		cv = Mockito.mock(CV.class);
		service = Mockito.mock(CVService.class);
		rest = Mockito.mock(CVEndpoint.class);
	}
	
	@Test
	public void getCVTest() {
		Mockito.when(rest.getCV(cv.getId())).thenReturn(Optional.of(cv));
		assertEquals(cv.toString(), rest.getCV(cv.getId()).get().toString());
	}
}
