package com.emanuel.eventmanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emanuel.eventmanager.entities.Event;

public interface EventRepository extends MongoRepository<Event, String>{
	

}
