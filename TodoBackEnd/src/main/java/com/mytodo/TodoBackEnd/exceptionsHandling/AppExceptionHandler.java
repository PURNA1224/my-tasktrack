package com.mytodo.TodoBackEnd.exceptionsHandling;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class AppExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
				errorMap.put(error.getField(), error.getDefaultMessage())
		);
		return new ResponseEntity<>(errorMap, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
