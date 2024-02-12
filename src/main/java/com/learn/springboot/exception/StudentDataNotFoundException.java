package com.learn.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentDataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentDataNotFoundException(String message) {
		super(message);
	}
}
