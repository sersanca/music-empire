package org.ssanta.musicempire.services.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError  {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	
	public CustomError(HttpStatus status, String message, String error) {
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

}
