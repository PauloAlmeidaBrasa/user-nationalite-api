package com.example.testequipux.repository;

import com.example.testequipux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}