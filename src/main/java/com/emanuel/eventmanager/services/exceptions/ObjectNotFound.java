package com.emanuel.eventmanager.services.exceptions;

public class ObjectNotFound extends RuntimeException{
	
	public ObjectNotFound(String id) {
		 super("Objeto nao encontrado. Id: " + id);
	}

}
