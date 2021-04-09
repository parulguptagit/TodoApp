package com.practise.converter;

import com.practise.dto.TodoDto;
import com.practise.model.Todo;

public class TodoConverter {
	public static Todo dtoToEntity(TodoDto todoDto) {
		  Todo todo = new Todo();
		  todo.setId(todoDto.getId());
		  todo.setUser(todoDto.getUser());
		  todo.setDesc(todoDto.getDesc());
		  todo.setDueBy(todoDto.getDueBy());
		  todo.setIsDone(todoDto.getIsDone());
		  return todo;
		 }

		 public static TodoDto entityToDto(Todo todo) {
		  TodoDto todoDto = new TodoDto(todo.getId(), todo.getuser(), todo.getDesc(), todo.getDueBy(), todo.getIsDone());
		  return todoDto;
		 }

}
