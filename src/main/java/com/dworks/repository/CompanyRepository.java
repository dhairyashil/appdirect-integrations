package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	Company findByUuid(String uuid);

}
