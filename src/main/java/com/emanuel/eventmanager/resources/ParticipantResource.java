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

import com.emanuel.eventmanager.DTO.ParticipantDTO;
import com.emanuel.eventmanager.entities.Participant;
import com.emanuel.eventmanager.services.ParticipantService;

@RestController
@RequestMapping(value = "/participants")
public class ParticipantResource {
	
	@Autowired
	public ParticipantService service;
	
	@GetMapping
	public ResponseEntity<List<ParticipantDTO>> findAll(){
		List<Participant> list = service.findAll();
		List<ParticipantDTO> listDTO = list.stream().map(x -> new ParticipantDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ParticipantDTO> findById(@PathVariable String id){
		Participant obj = service.findById(id);
		return ResponseEntity.ok().body(new ParticipantDTO(obj));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert (@RequestBody ParticipantDTO obj){
		Participant participant = obj.fromDTO(obj);
		participant = service.createParticipant(participant);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(participant.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.deleteParticipant(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ParticipantDTO obj){
		Participant participant = obj.fromDTO(obj);
		participant.setId(id);
		participant = service.updateParticipant(id, participant);
		return ResponseEntity.noContent().build();
	}
	

}
