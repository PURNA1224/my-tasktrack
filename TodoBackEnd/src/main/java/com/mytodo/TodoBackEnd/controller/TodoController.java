package com.mytodo.TodoBackEnd.controller;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytodo.TodoBackEnd.pojo.CreateTodoRequestModel;
import com.mytodo.TodoBackEnd.pojo.CreateTodoResponseModel;
import com.mytodo.TodoBackEnd.pojo.SummarizeRequest;
import com.mytodo.TodoBackEnd.pojo.TodoDto;
import com.mytodo.TodoBackEnd.service.TodoService;
import com.mytodo.TodoBackEnd.serviceImplementation.SlackService;
import com.mytodo.TodoBackEnd.serviceImplementation.TodoSummarizeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@Autowired
	TodoSummarizeService summarizeService;
	
	@Autowired
	SlackService slackService;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping("/getAllTodos")
	public ResponseEntity<List<CreateTodoResponseModel>> getAllTodos(){
		List<TodoDto> todoDtos = todoService.getAllTodos();
		
		List<CreateTodoResponseModel> todoResponseModel = new ArrayList<>();
		todoDtos.forEach(thistodo -> {
			todoResponseModel.add(mapper.map(thistodo, CreateTodoResponseModel.class));
		}
		);
		
		return ResponseEntity.ok().body(todoResponseModel);
		
		
	}
	
	@GetMapping("/getPendingTodos")
	public ResponseEntity<String> getPendingTodos(){
		String pendingTodos = todoService.getPendingTodos();
		return ResponseEntity.ok().body(pendingTodos);
	}
	
	@GetMapping("/getTodo/{id}")
	public ResponseEntity<?> getTodoById(@PathVariable int id) {
		TodoDto todoDto = todoService.getTodoById(id);
		CreateTodoResponseModel todoResponseModel = mapper.map(todoDto, CreateTodoResponseModel.class);
		return ResponseEntity.ok().body(todoResponseModel);		
	}
	
	@PostMapping("/createTodo")
	public ResponseEntity<?> addTodo(@Valid @RequestBody CreateTodoRequestModel todoRequest) {
		TodoDto todoReqDto = mapper.map(todoRequest, TodoDto.class);
		System.out.println(todoRequest);
		TodoDto todoDto = todoService.addTodo(todoReqDto);
		CreateTodoResponseModel todoResponse = mapper.map(todoDto, CreateTodoResponseModel.class);
		return ResponseEntity.ok().body(todoResponse);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateTodoStatus(@PathVariable int id, @RequestParam String isPending) {
		todoService.updateTodoStatus(id, isPending);
		return ResponseEntity.ok().body(isPending);

	}
	
	@DeleteMapping("/deleteTodo/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable int id){
		TodoDto todoDto = todoService.deleteTodo(id);
 		CreateTodoResponseModel todoResponse = mapper.map(todoDto, CreateTodoResponseModel.class);
 		return ResponseEntity.ok().body(todoResponse);
	}
	
	
	@PostMapping("/summarize")
	public ResponseEntity<String> generateSummary(@RequestBody SummarizeRequest summarizeRequest){
		String message = summarizeService.generateSummary(summarizeRequest);
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/sendMessage")
	public ResponseEntity<String> sendMessage(@RequestBody String summary){
		String response = slackService.sendToSlack(summary);
		return ResponseEntity.ok(response);
	}
}
