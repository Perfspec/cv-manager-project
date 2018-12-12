package com.qa.cv_manager.userapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cv_manager.userapi.persistence.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
