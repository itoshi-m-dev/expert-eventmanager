package com.emanuel.eventmanager.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.emanuel.eventmanager.entities.Participant;

public class ParticipantDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	private List<String> events = new ArrayList<>();
	
	public ParticipantDTO() {}
	
	public ParticipantDTO(Participant obj) {
		id = obj.getId();
		firstName = obj.getFirstName();
		lastName = obj.getLastName();
		email = obj.getEmail();
		phone = obj.getPhone();
	}
	

}
