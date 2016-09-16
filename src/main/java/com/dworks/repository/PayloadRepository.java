package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.Payload;

@Repository
public interface PayloadRepository extends CrudRepository<Payload, Long> {

}
