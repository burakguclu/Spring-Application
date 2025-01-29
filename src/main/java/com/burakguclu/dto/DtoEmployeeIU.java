package com.burakguclu.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeIU {
	private String firstName;
	private String lastName;
	private Date birthDate;
}
