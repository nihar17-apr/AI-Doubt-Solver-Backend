package com.nihar.backend.service;

import com.nihar.backend.dto.LoginRequest;
import com.nihar.backend.dto.LoginResponse;
import com.nihar.backend.dto.RegisterRequest;

public interface UserService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}