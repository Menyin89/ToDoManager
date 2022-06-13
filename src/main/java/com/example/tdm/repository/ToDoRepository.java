package com.example.tdm.repository;

import com.example.tdm.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ToDoRepository extends CrudRepository<ToDoItem, Integer> {

}
