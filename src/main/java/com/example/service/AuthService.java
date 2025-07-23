package com.example.service;

import com.example.User;

public interface AuthService {
    String register(User user);
    String login(String email, String password);
} 