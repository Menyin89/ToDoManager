package com.example.tdm.controller;

import com.example.tdm.model.ToDoItem;
import com.example.tdm.repository.ToDoRepository;
import com.example.tdm.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDoItems")
public class ToDoItemController {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoService toDoService;

    @PostMapping()
    public ToDoItem createToDoItem(@RequestBody ToDoItem toDoItem) {
        return this.toDoRepository.save(toDoItem);
    }

    @GetMapping
    public Iterable<ToDoItem> getAllToDoItems() {
        return this.toDoRepository.findAll();
    }

    @GetMapping("/actives")
    public List<ToDoItem> getAllActiveToDoItems() {
        return this.toDoService.findAllActive();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoItem> getToDoItemById(@PathVariable(value = "id") Integer id) {
        ToDoItem toDoItem = this.toDoRepository.findById(id).get();
        if (toDoItem == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(toDoItem);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoItem> updateToDoItem(@PathVariable(value = "id") Integer id,
                                                   @RequestBody ToDoItem toDoItem) {
        ToDoItem baseToDoItem = this.toDoRepository.findById(id).get();
        if (baseToDoItem == null) {
            return ResponseEntity.notFound().build();
        }
        baseToDoItem.setDone(toDoItem.isDone());

        ToDoItem updatedToDoItem = this.toDoRepository.save(baseToDoItem);
        return ResponseEntity.ok().body(updatedToDoItem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoItem> deleteToDoItem(@PathVariable(value = "id") Integer id) {
        ToDoItem toDoItem = this.toDoRepository.findById(id).get();
        if (toDoItem == null) {
            return ResponseEntity.notFound().build();
        }
        this.toDoRepository.delete(toDoItem);
        return ResponseEntity.ok().build();
    }
}
