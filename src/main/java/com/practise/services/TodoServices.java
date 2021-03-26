package com.practise.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.practise.model.Todo;
import com.practise.repository.TodoRepository;

@Service("todoService")
public class TodoServices implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo addTodo(String user, String desc, Boolean isDone)
	{
		
		Todo todo = new Todo();
		todo.setUser(user);
		todo.setDesc(desc);
		todo.setIsDone(isDone);
		todo.setDueBy(new Date());
		return todoRepository.save(todo);
	}
	
	public List<Todo> getTodos(String user)
	{
		List<Todo> filteredTodos = new ArrayList<Todo>();
		
		for (Todo todo : todoRepository.findAll())
		{
			if (todo.getuser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
		
	}
	
	public Optional<Todo> getTodoById(int id)
	{
		
		return todoRepository.findById(id);
	}
	
	
	
	public void deleteById(int id)
	{
		todoRepository.deleteById(id);
	}
	
	public Todo updateTodo(String user,int id,Todo todo)
	{
		if (todoRepository.findById(id) != null)
		{	
			todo.setId(id);
			todo.setUser(user);
			todo.setDueBy(new Date());
			return todoRepository.save(todo);
		}
		return null;
	}
	
	@Override
	public List<Todo> getAllTodos() {
		List < Todo > todoList = todoRepository.findAll();
        return todoList;
	}
}
