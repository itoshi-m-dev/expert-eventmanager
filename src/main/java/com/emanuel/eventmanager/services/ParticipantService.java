package com.emanuel.eventmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.eventmanager.entities.Participant;
import com.emanuel.eventmanager.repositories.ParticipantRepository;
import com.emanuel.eventmanager.services.exceptions.ObjectNotFound;

@Service
public class ParticipantService {

	@Autowired
	public ParticipantRepository repo;

	public Participant createParticipant(Participant obj) {
		return repo.insert(obj);
	}

	public List<Participant> findAll() {
		return repo.findAll();
	}

	public Participant findById(String id) {
		Optional<Participant> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound(id));

	}

	public Participant updateParticipant(String id, Participant participant) {
		Participant obj = findById(id);
		updataData(obj, participant);
		return repo.save(obj);
		
	}
	
	public void deleteParticipant(String id) {
		Participant obj = findById(id);
		repo.delete(obj);
	}

	private void updataData(Participant obj, Participant participant) {
		obj.setFirstName(participant.getFirstName());
		obj.setLastName(participant.getLastName());
		obj.setEmail(participant.getEmail());
		obj.setPhone(participant.getPhone());

	}

}
