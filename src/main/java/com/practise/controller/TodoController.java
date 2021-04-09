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

import com.practise.model.Todo;
import com.practise.repository.TodoRepository;
import com.practise.services.TodoService;
import com.practise.services.TodoServices;

@RestController	
public class TodoController {
	
	@Resource(name = "todoService")
	private TodoService todoService;
	
	
	@GetMapping("/todos/")
	public List<Todo> findAll()
	{
		return todoService.getAllTodos();
	}
	
	
	@GetMapping("/todos/{user}")
	public List<Todo> getTodos(@PathVariable String user)
	{
		return todoService.getTodos(user);
	}
	
	@GetMapping(value = "/todos/{user}/{id}", produces = {"application/json","application/xml"})
	public Optional<Todo> getTodos(@PathVariable String user, @PathVariable int id)
	{
		return todoService.getTodoById(id);
	}
	
	@DeleteMapping("/todos/{user}/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String user, @PathVariable int id)
	{
		if ( todoService.getTodoById(id) != null)
		{
				todoService.deleteById(id);
				return ResponseEntity.noContent().build(); 
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@PutMapping("/todos/{user}/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String user, @PathVariable int id, @RequestBody Todo todo)
	{
		System.out.println(todo);
		if (todoService.updateTodo(user,id,todo) != null)
		{
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		}
		return new ResponseEntity<Todo>(todo, HttpStatus.METHOD_FAILURE);
	}
	
	@PostMapping("/todos/{user}")
	public ResponseEntity<?> add(@PathVariable String user, @RequestBody Todo todo) {
			Todo createdTodo = todoService.addTodo(user, todo.getDesc(), todo.getIsDone());
			if (createdTodo == null) {
				return ResponseEntity.noContent().build();
			}
			URI location =	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(location).build();
	}
	
}
