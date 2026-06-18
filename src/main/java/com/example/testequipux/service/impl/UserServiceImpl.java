package com.example.testequipux.service.impl;

import com.example.testequipux.dto.request.CreateUserRequest;
import com.example.testequipux.entity.User;
import com.example.testequipux.exception.DuplicateResourceException;
import com.example.testequipux.exception.InvalidCredentialsException;
import com.example.testequipux.exception.ResourceNotFoundException;
import com.example.testequipux.repository.UserRepository;
import com.example.testequipux.security.JwtTokenProvider;
import com.example.testequipux.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository repository, JwtTokenProvider jwtTokenProvider) {
        this.repository = repository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User createUser(CreateUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (repository.existsByDocument(request.getDocument())) {
            throw new DuplicateResourceException("Document already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setDocument(request.getDocument());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // later you should hash this

        return repository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteUserById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public String login(String email, String password) {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        return jwtTokenProvider.createToken(user.getEmail());
    }
}