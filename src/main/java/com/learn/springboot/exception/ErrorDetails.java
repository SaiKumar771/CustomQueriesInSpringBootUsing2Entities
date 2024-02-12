package com.learn.springboot.exception;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDetails {

	private String message;
	private String details;
	private ZonedDateTime date;
}
