package com.ACO.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ACO.domain.CV;


public interface CVRepository extends CrudRepository<CV, Integer> {

	 @Query("SELECT a FROM CV a where a.username = :username") 
	    Iterable<CV> getByUsername(@Param("username") String username);
}
