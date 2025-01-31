package com.burakguclu.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeIU {
	@NotEmpty(message = "Do not leave first name empty!")
	@Size(max = 50, min = 3, message = "Length of first name should be higher than {min} and less than {max}!")
	private String firstName;
	
	@NotEmpty(message = "Do not leave last name empty!")
	@Size(max = 50, min = 3, message = "Length of first name should be higher than {min} and less than {max}!")
	private String lastName;

	private Date birthDate;
}
