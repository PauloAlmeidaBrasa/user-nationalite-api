package com.example.testequipux.repository;

import com.example.testequipux.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll() {

        return List.of(
                new User(
                        1L,
                        "Paulo",
                        "paulo@email.com"
                ),
                new User(
                        2L,
                        "John",
                        "john@email.com"
                )
        );
    }
}