package com.example.tdm.service;

import com.example.tdm.model.User;
import com.example.tdm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(Integer code, String name) {
        return userRepository.findById(code)
                .orElse(userRepository.save(new User(code, name)));
    }

    public User findById(Integer code) {
        return userRepository.findById(code)
                .orElse(null);
    }
}
