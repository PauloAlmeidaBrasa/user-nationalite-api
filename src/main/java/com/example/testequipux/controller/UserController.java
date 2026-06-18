package com.example.testequipux.controller;

import com.example.testequipux.dto.request.CreateUserRequest;
import com.example.testequipux.entity.User;
import com.example.testequipux.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<User> list() {
        return service.listUsers();
    }

    @PostMapping("/create")
    public User create(@Valid @RequestBody CreateUserRequest request) {
        return service.createUser(request);
    }
}