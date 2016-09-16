package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.MarketPlace;

@Repository
public interface MarketplaceRepository extends CrudRepository<MarketPlace, String> {

}
