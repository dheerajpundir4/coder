package com.qwetzal.coder.service.impl;

import com.qwetzal.coder.dto.LoginRequest;
import com.qwetzal.coder.dto.RegisterRequest;
import com.qwetzal.coder.entities.User;
import com.qwetzal.coder.exceptions.InvalidCredentialsException;
import com.qwetzal.coder.repositories.UserRepository;
import com.qwetzal.coder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest registerRequest) {
        User user = new User().setUsername(registerRequest.getUsername())
                .setFullName(registerRequest.getFullName())
                .setEmail(registerRequest.getEmail())
                .setPassword(registerRequest.getPassword())
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public User login(LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(),
                loginRequest.getPassword())
                .orElseThrow(() -> new InvalidCredentialsException());
    }
}
