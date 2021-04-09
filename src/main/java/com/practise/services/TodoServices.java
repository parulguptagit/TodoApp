package com.practise.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.converter.TodoConverter;
import com.practise.dto.TodoDto;
import com.practise.model.Todo;
import com.practise.repository.TodoRepository;

@Service("todoService")
public class TodoServices implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo addTodo(TodoDto todoDto)
	{
		
		Todo todo = new Todo();
		todo.setUser(todoDto.getUser());
		todo.setDesc(todoDto.getDesc());
		todo.setIsDone(todoDto.getIsDone());
		todo.setDueBy(new Date());
		return todoRepository.save(todo);
	}
	
	public List<TodoDto> getTodos(String user)
	{
		List<Todo> filteredTodos = new ArrayList<Todo>();
		
		for (Todo todo : todoRepository.findAll())
		{
			if (todo.getuser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos.stream().map(TodoConverter::entityToDto).collect(Collectors.toList());	
	}
	
	public TodoDto getTodoById(int id)
	{
		
		return TodoConverter.entityToDto(todoRepository.getOne(id));
	}
	
	
	
	public void deleteById(int id)
	{
		todoRepository.deleteById(id);
	}
	
	public Todo updateTodo(String user,int id,TodoDto todoDto)
	{
		Todo todo = todoRepository.getOne(id);
		if (todo != null)
		{	
			todo.setId(id);
			todo.setUser(todoDto.getUser());
			todo.setDueBy(new Date());
			todo.setDesc(todoDto.getDesc());
			todo.setIsDone(todoDto.getIsDone());
			return todoRepository.save(todo);
		}
		return null;
	}
	
	@Override
	public List<TodoDto> getAllTodos() {
		List < Todo > todoList = todoRepository.findAll();
        return todoList.stream().map(TodoConverter::entityToDto).collect(Collectors.toList());
	}
}
