package com.emanuel.eventmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.eventmanager.entities.Event;
import com.emanuel.eventmanager.repositories.EventRepository;
import com.emanuel.eventmanager.services.exceptions.ObjectNotFound;

@Service
public class EventService {
	
	@Autowired
	public EventRepository repo;
	
	
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
	
	public void addParticipant(String eventId, String ParticipantId) {
		Event obj = findById(eventId);
		obj.getParticipantsId().add(ParticipantId);
		
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
