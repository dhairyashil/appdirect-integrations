package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
