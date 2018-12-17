package com.qa.cv_manager.consumer.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.cvapi.persistence.domain.CV;

@Repository
public interface CVRepsoitory extends MongoRepository<CV, Integer> {
}
