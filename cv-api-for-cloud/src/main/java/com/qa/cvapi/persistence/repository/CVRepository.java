package com.qa.cvapi.persistence.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.cvapi.persistence.domain.CV;

@Repository
public interface CVRepository extends CrudRepository<CV, Integer> {

}
