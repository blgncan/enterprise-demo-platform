package com.blgncan.enterprise.api.service;

import com.blgncan.enterprise.api.dto.request.LoginRequest;
import com.blgncan.enterprise.api.dto.request.RegisterRequest;
import com.blgncan.enterprise.api.dto.response.LoginResponse;
import com.blgncan.enterprise.api.dto.response.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);

    RegisterResponse register(RegisterRequest request);
}
