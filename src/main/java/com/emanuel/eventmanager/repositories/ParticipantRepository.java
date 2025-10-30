package com.emanuel.eventmanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emanuel.eventmanager.entities.Participant;

public interface ParticipantRepository extends MongoRepository<Participant, String>{

}
