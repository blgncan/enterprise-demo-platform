package com.blgncan.enterprise.api.controller;

import com.blgncan.enterprise.api.dto.request.LoginRequest;
import com.blgncan.enterprise.api.dto.request.RegisterRequest;
import com.blgncan.enterprise.api.dto.response.LoginResponse;
import com.blgncan.enterprise.api.dto.response.RegisterResponse;
import com.blgncan.enterprise.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public RegisterResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}
