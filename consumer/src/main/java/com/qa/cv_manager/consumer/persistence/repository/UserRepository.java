package com.qa.cv_manager.consumer.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.cv_manager.usercreationapi.persistence.domain.UserPOJO;

@Repository
public interface UserRepository extends MongoRepository<UserPOJO, String> {
}
