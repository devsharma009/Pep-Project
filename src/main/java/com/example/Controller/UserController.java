package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.User;
import com.example.UserRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userRepository.findById(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        return userRepository.findById(username)
            .map(user -> {
                user.setEmail(updatedUser.getEmail());
                user.setName(updatedUser.getName());
                user.setPassword(updatedUser.getPassword());
                user.setRole(updatedUser.getRole());
                userRepository.save(user);
                return ResponseEntity.ok(user);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

