package com.example.testequipux.service;

import com.example.testequipux.dto.request.CreateUserRequest;
import com.example.testequipux.entity.User;
import java.util.List;

public interface UserService {
    User createUser(CreateUserRequest request);
    List<User> listUsers();
}