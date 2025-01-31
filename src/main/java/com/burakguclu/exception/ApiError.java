package com.burakguclu.exception;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ApiError {
	private String id;
	private Date errorTime;
	private Map<String, List<String>> errors;
}
