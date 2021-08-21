package com.example.omnirio.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.omnirio.constants.StatusMessages;

@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ServiceException.class})
	public ResponseEntity<Object> throwServiceException() {
		return ResponseEntity.status(501).body(StatusMessages.ERR_COMMON_EXCEPTION);
	}
	
	@ExceptionHandler({ControllerException.class})
	public ResponseEntity<Object> throwControllerException() {
		return ResponseEntity.status(501).body(StatusMessages.ERR_COMMON_EXCEPTION);
	}
	
	@ExceptionHandler({DataNotFoundException.class})
	public ResponseEntity<Object> throwDataNotFoundException() {
		return ResponseEntity.status(501).body(StatusMessages.ERR_DATA_NOT_FOUND);
	}
}
