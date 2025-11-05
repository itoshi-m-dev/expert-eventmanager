package com.emanuel.eventmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.eventmanager.DTO.ParticipantDTO;
import com.emanuel.eventmanager.entities.Event;
import com.emanuel.eventmanager.entities.Participant;
import com.emanuel.eventmanager.repositories.EventRepository;
import com.emanuel.eventmanager.repositories.ParticipantRepository;
import com.emanuel.eventmanager.services.exceptions.ObjectNotFound;

@Service
public class EventService {
	
	@Autowired
	public EventRepository repo;
	
	@Autowired
	public ParticipantRepository participantRepo;
	
	
	public Event createEvent(Event event) {
		return repo.insert(event);
	}
	
	public List<Event> findAll() {
		return repo.findAll();
		
	}
	
	public Event findById(String id) {
		Optional<Event> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound(id));
	}
	
	public Event updateEvent(String id, Event event) {
		Event obj = findById(id);
		updateData(obj, event);
		return repo.save(obj);
		
	}
	
	public void deleteEvent(String id) {
		Event obj = findById(id);
		repo.delete(obj);
	}
	
	public void addParticipant(String eventId, ParticipantDTO dto) {
	    Event event = findById(eventId);

	    
	    Participant participant = participantRepo.findById(dto.getId())
	    		.orElseGet(() -> new Participant(null, dto.getFirstName(), dto.getLastName(), dto.getEmail(),
	    				dto.getPhone(), new ArrayList<>()));
	    
	    		participant = participantRepo.save(participant);

	    // Associa o evento a ele
	    participant.getEvents().add(eventId);
	    participantRepo.save(participant);

	    // Adiciona o participante ao evento
	    event.getParticipantsId().add(participant.getId());
	    repo.save(event);
	}


	private void updateData(Event obj, Event event) {
		obj.setName(event.getName());;
		obj.setDescription(event.getDescription());
		obj.setLocation(event.getLocation());
		obj.setStartDate(event.getStartDate());
		obj.setEndDate(event.getEndDate());
		obj.setMaxParticipants(event.getMaxParticipants());
				
	}
	
	
	
	
	
	
	
	
	

}
