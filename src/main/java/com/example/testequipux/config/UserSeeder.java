package com.example.testequipux.config;

import com.example.testequipux.entity.User;
import com.example.testequipux.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        String email = "paulo@email.com";
        String document = "12345678901";

        if (userRepository.existsByEmail(email) || userRepository.existsByDocument(document)) {
            return;
        }

        User user = new User();
        user.setName("Paulo");
        user.setLastName("Roberto");
        user.setEmail(email);
        user.setPassword("123");
        user.setDocument(document);

        userRepository.save(user);
    }
}
