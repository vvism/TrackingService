package com.hclpractics.trackingservice.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hclpractics.trackingservice.dto.ResponseDTO;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handelMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		ResponseDTO responseDto = new ResponseDTO(errors, HttpStatus.NOT_FOUND, LocalDateTime.now(), new ArrayList());

		return new ResponseEntity<Object>(responseDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchTrackingNumberExistsException.class)
	public ResponseEntity<Object> handleNoSuchCustomerExistsException(NoSuchTrackingNumberExistsException ex) {
		Map<String, String> errors = new HashMap<>();

		System.out.println(ex.getMessage());
		errors.put("message", ex.getMessage());
		ResponseDTO responseDto = new ResponseDTO(errors, HttpStatus.BAD_REQUEST, LocalDateTime.now(), new ArrayList());

		return new ResponseEntity<Object>(responseDto, HttpStatus.BAD_REQUEST);

	}

}
