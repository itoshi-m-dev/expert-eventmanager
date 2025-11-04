package com.emanuel.eventmanager.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emanuel.eventmanager.DTO.EventDTO;
import com.emanuel.eventmanager.DTO.ParticipantDTO;
import com.emanuel.eventmanager.entities.Event;
import com.emanuel.eventmanager.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

	@Autowired
	public EventService service;

	@GetMapping
	public ResponseEntity<List<EventDTO>> findAll() {
		List<Event> list = service.findAll();
		List<EventDTO> listDTO = list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EventDTO> findById(@PathVariable String id) {
		Event obj = service.findById(id);
		return ResponseEntity.ok().body(new EventDTO(obj));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateEvent(@PathVariable String id, @RequestBody EventDTO event) {
		Event obj = service.findById(id);
		obj.setId(id);
		obj = service.updateEvent(id, obj);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{eventId}/participants")
	public ResponseEntity<Void> addParticipant(@PathVariable String eventId, @RequestBody ParticipantDTO participant) {
	    service.addParticipant(eventId, participant);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	            .build()
	            .toUri();
	    return ResponseEntity.created(uri).build();
	}

}
