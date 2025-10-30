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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}
	
	
	

}
