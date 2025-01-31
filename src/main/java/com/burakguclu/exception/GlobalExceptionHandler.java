package com.burakguclu.exception;

import java.io.ObjectInputStream.GetField;
import java.net.http.HttpResponse.ResponseInfo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		Map<String, List<String>> errorMap = new HashMap<>();
		for (ObjectError o : exception.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) o).getField();
			if (errorMap.containsKey(fieldName)) {
				errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), o.getDefaultMessage()));
			} else {
				errorMap.put(fieldName, addMapValue(new ArrayList<>(), o.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorMap));	
	}
	
	private ApiError createApiError(Map<String, List<String>> errors) {
		ApiError apiError = new ApiError();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date(0));
		apiError.setErrors(errors);
		return apiError;
	}

}
