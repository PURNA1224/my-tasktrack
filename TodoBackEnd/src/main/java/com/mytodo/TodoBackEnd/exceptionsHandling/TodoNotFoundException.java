package com.mytodo.TodoBackEnd.exceptionsHandling;

public class TodoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TodoNotFoundException(String message) {
		super(message);
	}

}
