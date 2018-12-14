package com.qa.cvtraineeservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.cvtraineeservice.domain.IterablePojoCV;
import com.qa.cvtraineeservice.domain.PojoCV;

@RestController
public class TraineeEndpoint {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Value("${cv-root}")
	private String root;
	@Value("${cv-path-ep}")
	private String path;	
	@Value("${cv-getcv-ep}")
	private String getcv;	
	@Value("${cv-getcvs-ep}")
	private String getcvs;	
	@Value("${cv-delete-ep}")
	private String delete;	
	@Value("${deleted-msg}")
	private String deleteMsg;	
	@Value("${cv-update-ep}")
	private String update;
	
	
	@GetMapping(path="${cv-getcv-ep}"+"{id}")
	public @ResponseBody PojoCV getCV(@PathVariable int id) {
		return template.getForObject(root+path+getcv+id, PojoCV.class);
	}
	
	@GetMapping(path="${cv-getcvs-ep}")
	public @ResponseBody IterablePojoCV getCVs(@RequestBody Iterable<Integer> ids) {
		return template.getForObject(root+path+getcvs, IterablePojoCV.class);
	}
	
	@DeleteMapping(path="${cv-delete-ep}")
	public String deleteCV(@PathVariable int id) {
		template.delete(root+path+delete+id);
		return deleteMsg;
	}
	
	@PutMapping(path="${cv-update-ep}")
	public String updateteCV(@PathVariable int id, @RequestBody PojoCV cv) {
		HttpEntity<PojoCV> requestUpdate = new HttpEntity<>(cv, headers);
		return template.exchange(root+path+update+id, HttpMethod.PUT, requestUpdate, String.class).getBody();
	}
}
