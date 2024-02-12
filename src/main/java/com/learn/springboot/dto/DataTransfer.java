package com.learn.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * Difference:
	@JsonIgnoreProperties is used to ignore specific properties altogether.
	@JsonInclude(value = Include.NON_DEFAULT) is used to include properties based on their values, excluding those with default values.
	In summary, @JsonIgnoreProperties is about excluding specific properties from serialization, while @JsonInclude(value = Include.NON_DEFAULT) 
	is about selectively including properties based on their values. Depending on your use case, you might choose one or both annotations.
 */

/*
 * The @JsonIgnoreProperties annotation in Jackson (a JSON library used in Java) is used to  tell the 
 * ObjectMapper (the component responsible for converting Java 
 * objects to JSON and vice versa) to ignore any unknown properties in a JSON object when converting it to a Java object.
 * 
 */
@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_DEFAULT)
public class DataTransfer {

	private String studentName;
	private double fee;
	private String courseName;

	public DataTransfer(String studentName, double fee) {
		super();
		this.studentName = studentName;
		this.fee = fee;
	}

	public DataTransfer(String studentName, String courseName) {
		super();
		this.studentName = studentName;
		this.courseName = courseName;
	}

}
