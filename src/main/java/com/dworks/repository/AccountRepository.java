package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

}
