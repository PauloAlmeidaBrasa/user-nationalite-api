package com.example.testequipux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/v1/user/list")
    public String list() {
        return "Users endpoint workingggg!";
    }
}