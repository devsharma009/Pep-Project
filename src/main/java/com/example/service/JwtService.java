package com.example.service;

import com.example.User;

public interface JwtService {
    String generateToken(User user);
    boolean validateToken(String token, User user);
    String extractUsername(String token);
} 