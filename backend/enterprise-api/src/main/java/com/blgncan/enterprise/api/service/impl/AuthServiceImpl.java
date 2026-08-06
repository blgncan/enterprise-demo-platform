package com.blgncan.enterprise.api.service.impl;

import com.blgncan.enterprise.api.dto.request.LoginRequest;
import com.blgncan.enterprise.api.dto.request.RegisterRequest;
import com.blgncan.enterprise.api.dto.response.LoginResponse;
import com.blgncan.enterprise.api.dto.response.RegisterResponse;
import com.blgncan.enterprise.api.entity.AppUser;
import com.blgncan.enterprise.api.repository.UserRepository;
import com.blgncan.enterprise.api.security.JwtService;
import com.blgncan.enterprise.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());

        return new LoginResponse(token);

    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        AppUser user = new AppUser();

        user.setUsername(request.getUsername());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("ROLE_USER");

        userRepository.save(user);

        return new RegisterResponse("User registered successfully");
    }
}
