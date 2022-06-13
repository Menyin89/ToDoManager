package com.example.tdm.service;

import com.example.tdm.model.ToDoItem;
import com.example.tdm.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoItem> findAllActive() {
        List<ToDoItem> result = new ArrayList<ToDoItem>();
        toDoRepository.findAll().forEach(toDoItem -> {
            if (!toDoItem.isDone()) {
                result.add(toDoItem);
            }
        });
        return result;
    }
}
