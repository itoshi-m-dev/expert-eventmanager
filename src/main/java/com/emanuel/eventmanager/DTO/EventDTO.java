package com.emanuel.eventmanager.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.emanuel.eventmanager.entities.Event;

public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String description;
	private String location;
	private Date startDate;
	private Date endDate;
	private Integer maxParticipants;

	private List<String> participantsId = new ArrayList<>();
	
	public EventDTO() {
		
	}
	
	public EventDTO(Event obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		location = obj.getLocation();
		startDate = obj.getStartDate();
		endDate = obj.getEndDate();
		maxParticipants = obj.getMaxParticipants();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public List<String> getParticipantsId() {
		return participantsId;
	}

	
	
	
	
	
	

}
