package com.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
