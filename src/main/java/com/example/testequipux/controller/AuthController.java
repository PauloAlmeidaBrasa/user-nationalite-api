package com.example.testequipux.controller;

import com.example.testequipux.dto.request.LoginRequest;
import com.example.testequipux.dto.response.LoginResponse;
import com.example.testequipux.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        String token = userService.login(request.getEmail(), request.getPassword());
        return new LoginResponse(token);
    }
}
