package com.qa.cv_manager.usercreationapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cv_manager.usercreationapi.persistence.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
