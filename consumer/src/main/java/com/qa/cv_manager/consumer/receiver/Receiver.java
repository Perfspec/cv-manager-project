package com.qa.cv_manager.consumer.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.cv_manager.consumer.persistence.repository.CVRepsoitory;
import com.qa.cv_manager.consumer.persistence.repository.UserRepository;
import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;
import com.qa.cvapi.persistence.domain.CV;

@Component
public class Receiver {

	@Autowired
	private CVRepsoitory cvRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@JmsListener(destination = "${queue.saveUser}", containerFactory = "myFactory")
	public void receiveUsers(UserPOJO user) {
		userRepo.save(user);
	}
	
	@JmsListener(destination = "${queue.saveCV}", containerFactory = "myFactory")
	public void receiveUsers(CV cv) {
		cvRepo.save(cv);
	}
}
