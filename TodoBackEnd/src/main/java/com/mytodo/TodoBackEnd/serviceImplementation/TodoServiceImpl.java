package com.mytodo.TodoBackEnd.serviceImplementation;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytodo.TodoBackEnd.entities.TodoEntity;
import com.mytodo.TodoBackEnd.exceptionsHandling.TodoNotFoundException;
import com.mytodo.TodoBackEnd.pojo.TodoDto;
import com.mytodo.TodoBackEnd.repositories.TodoRepository;
import com.mytodo.TodoBackEnd.service.TodoService;


@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoRepository todoRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<TodoDto> getAllTodos() {
		
		Iterable<TodoEntity> todo=  todoRepo.findAll();
		List<TodoDto> todoDtos = new ArrayList<>();
		
		todo.forEach(thisTodo -> {
			todoDtos.add(mapper.map(thisTodo, TodoDto.class));
		});
		
		return todoDtos;
	}
	
	@Override
	public TodoDto getTodoById(int id) throws TodoNotFoundException{
		Optional<TodoEntity> todo = todoRepo.findById(id);
		if(todo.isEmpty())
			throw new TodoNotFoundException("Todo doesn't exist with id " + id);
		TodoDto todoDto = mapper.map(todo, TodoDto.class);
		return todoDto;
	}

	@Override
	public TodoDto addTodo(TodoDto todoReq) {
		TodoEntity todo = mapper.map(todoReq, TodoEntity.class);
		todoRepo.save(todo);
		TodoDto todoDto = mapper.map(todo, TodoDto.class);
		return todoDto;
	}

	@Override
	public TodoDto deleteTodo(int id) throws TodoNotFoundException {
		Optional<TodoEntity> todo = todoRepo.findById(id);
		if(todo.isEmpty()) {
			throw new TodoNotFoundException("Todo doesn't exist with id " + id);
		}
		else {
			todoRepo.deleteById(id);
			return mapper.map(todo, TodoDto.class);
		}
	}

	@Override
	public TodoDto updateTodo(TodoDto todoReq, int id) throws TodoNotFoundException {
		
		Optional<TodoEntity> checkTodo = todoRepo.findById(id);
		if(checkTodo.isEmpty()) {
			throw new TodoNotFoundException("Todo doesn't exist with id " + id);
		}
		
		TodoEntity todo = mapper.map(todoReq, TodoEntity.class);
		todo.setId(id);
		TodoEntity savedTodo = todoRepo.save(todo);

		return mapper.map(savedTodo, TodoDto.class);
	}

	@Override
	public void updateTodoStatus(int id, String isPending) {
		
		TodoEntity checkTodo = todoRepo.findById(id).get();
		boolean pendingStatus = (isPending.toLowerCase().equals("true")) ? true : false;
		checkTodo.setIsPending(pendingStatus);
		System.out.println(pendingStatus);
		todoRepo.save(checkTodo);
		
	}

	@Override
	public String getPendingTodos() {
		List<TodoEntity> pendingTodos =  todoRepo.findByIsPending(true);
		StringBuffer result = new StringBuffer();
		pendingTodos.forEach(todo -> result.append(todo.getTitle() + " - " + todo.getDescription() + " (Due: " + todo.getEndDate() + "), "));
		result.append(".");
		return result.toString();
	}
}
