package com.practise.services;

import java.util.List;
import java.util.Optional;

import com.practise.dto.TodoDto;
import com.practise.model.Todo;

public interface TodoService {
	
	public List<TodoDto> getAllTodos();
	public Todo addTodo(TodoDto todoDto);
	public List<TodoDto> getTodos(String user);
	public TodoDto getTodoById(int id);
	public void deleteById(int id);
	public Todo updateTodo(String user,int id,TodoDto todoDto);

}
