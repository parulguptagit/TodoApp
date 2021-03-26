package com.practise.services;

import java.util.List;
import java.util.Optional;

import com.practise.model.Todo;

public interface TodoService {
	
	public List<Todo> getAllTodos();
	public Todo addTodo(String user, String desc, Boolean isDone);
	public List<Todo> getTodos(String user);
	public Optional<Todo> getTodoById(int id);
	public void deleteById(int id);
	public Todo updateTodo(String user,int id,Todo todo);

}
