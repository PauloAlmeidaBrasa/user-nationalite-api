package com.example.testequipux.service;

import com.example.testequipux.entity.User;
import com.example.testequipux.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listUsers() {
        return repository.findAll();
    }
}