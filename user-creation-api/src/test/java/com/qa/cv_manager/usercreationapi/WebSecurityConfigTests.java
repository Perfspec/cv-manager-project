package com.qa.cv_manager.usercreationapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.cv_manager.usercreationapi.util.constants.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebSecurityConfigTests {

	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void getAllTest() {
		template.postForEntity("/addUser", Constants.TEST_USER_POJO, String.class);
		assertEquals('[', template.withBasicAuth(Constants.MOCK_USERNAME, Constants.MOCK_PASSWORD).getForObject("/getAll", String.class).charAt(0));
	}
	
	@Test
	public void noAccessGetAllTest() {
		assertNotEquals('[', template.withBasicAuth(Constants.MOCK_USERNAME, Constants.USER).getForObject("/getAll", String.class).charAt(0));
	}
}
