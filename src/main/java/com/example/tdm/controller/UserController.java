package com.example.tdm.controller;

import com.example.tdm.model.User;
import com.example.tdm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getToDoItemById(@PathVariable(value = "id") Integer id) {
        User user = this.userRepository.findById(id).get();
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateToDoItem(@PathVariable(value = "id") Integer id,
                                                   @RequestBody User user) {
        User baseUser = this.userRepository.findById(id).get();
        if (baseUser == null) {
            return ResponseEntity.notFound().build();
        }
        baseUser.setUserName(user.getUserName());

        User updatedUser = this.userRepository.save(baseUser);
        return ResponseEntity.ok().body(updatedUser);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteToDoItem(@PathVariable(value = "id") Integer id) {
        User user = this.userRepository.findById(id).get();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        this.userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
