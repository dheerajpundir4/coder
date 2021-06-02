package com.qwetzal.coder.service;

import com.qwetzal.coder.dto.LoginRequest;
import com.qwetzal.coder.dto.RegisterRequest;
import com.qwetzal.coder.entities.User;

public interface AuthService {
    User registerUser(RegisterRequest registerRequest);

    User login(LoginRequest loginRequest);
}
