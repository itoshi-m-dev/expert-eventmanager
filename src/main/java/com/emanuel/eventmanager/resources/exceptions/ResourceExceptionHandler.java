package com.emanuel.eventmanager.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emanuel.eventmanager.services.exceptions.ObjectNotFound;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler{
	
	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e, HttpServletRequest request){
		
		HttpStatus err = HttpStatus.NOT_FOUND;
		StandardError se = new StandardError(System.currentTimeMillis(), err.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(err).body(se);
		
	}

}
