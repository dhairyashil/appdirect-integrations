package com.dworks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dworks.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	Event findByPayloadAccountAccountIdentifier(String id);
}
