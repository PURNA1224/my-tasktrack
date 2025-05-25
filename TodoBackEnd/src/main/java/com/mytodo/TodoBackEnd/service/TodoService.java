package com.mytodo.TodoBackEnd.service;

import java.util.List;

import com.mytodo.TodoBackEnd.pojo.TodoDto;

import jakarta.validation.Valid;

public interface TodoService {
	public List<TodoDto> getAllTodos();
	public TodoDto getTodoById(int id);
	public TodoDto addTodo(TodoDto todo);
	public TodoDto deleteTodo(int id);
	public TodoDto updateTodo(TodoDto todoReq, int id);
	public void updateTodoStatus(int id, @Valid String isPending);
	public String getPendingTodos();
}
