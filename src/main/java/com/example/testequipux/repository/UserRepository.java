package com.example.testequipux.repository;

import com.example.testequipux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByDocument(String document);
    Optional<User> findByEmail(String email);
}