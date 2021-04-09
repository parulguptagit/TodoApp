package com.practise.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practise.dto.TodoDto;
import com.practise.model.Todo;
import com.practise.repository.TodoRepository;
import com.practise.services.TodoService;
import com.practise.services.TodoServices;
import com.practise.utils.Constants;

@RestController	
public class TodoController {
	
	@Resource(name = "todoService")
	private TodoService todoService;
	
	
	@GetMapping(Constants.GET_ALL_TODOS)
	public List<TodoDto> findAll()
	{
		return todoService.getAllTodos();
	}
	
	
	@GetMapping(Constants.GET_TODOS_BY_USER)
	public List<TodoDto> getTodos(@PathVariable String user)
	{
		return todoService.getTodos(user);
	}
	
	@GetMapping(Constants.GET_TODO_BY_ID)
	public TodoDto getTodoById(@PathVariable int id)
	{
		return todoService.getTodoById(id);
	}
	
	@DeleteMapping(Constants.DELETE_TODO)
	public ResponseEntity<Void> deleteTodo(@PathVariable String user, @PathVariable int id)
	{
		if ( todoService.getTodoById(id) != null)
		{
				todoService.deleteById(id);
				return ResponseEntity.noContent().build(); 
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@PutMapping(Constants.UPDATE_TODO)
	public ResponseEntity<TodoDto> updateTodo(@PathVariable String user, @PathVariable int id, @RequestBody TodoDto todoDto)
	{
		System.out.println(todoDto);
		if (todoService.updateTodo(user,id,todoDto) != null)
		{
			return new ResponseEntity<TodoDto>(todoDto, HttpStatus.OK);
		}
		return new ResponseEntity<TodoDto>(todoDto, HttpStatus.METHOD_FAILURE);
	}
	
	@PostMapping(Constants.SAVE_TODO)
	public ResponseEntity<?> add(@PathVariable String user, @RequestBody TodoDto todoDto) {
			Todo createdTodo = todoService.addTodo(todoDto);
			if (createdTodo == null) {
				return ResponseEntity.noContent().build();
			}
			URI location =	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(location).build();
	}
	
}
