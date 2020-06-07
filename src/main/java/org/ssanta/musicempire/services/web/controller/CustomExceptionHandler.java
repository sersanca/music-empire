package org.ssanta.musicempire.services.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	 	 
	 	
	 	 @ExceptionHandler(NotFoundException.class)
	     public ResponseEntity<CustomError> onNotFoundError(NotFoundException ex){

	 		CustomError error = new CustomError(HttpStatus.NOT_FOUND, "Not Found", ex.getLocalizedMessage());
	 		
	         return new ResponseEntity<>( error, error.getStatus());
	     }
	 	 

	    
}


 
