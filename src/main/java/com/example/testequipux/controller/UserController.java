package com.example.testequipux.controller;

import com.example.testequipux.entity.User;
import com.example.testequipux.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/user/list")
    public List<User> list() {
        return service.listUsers();
    }
}