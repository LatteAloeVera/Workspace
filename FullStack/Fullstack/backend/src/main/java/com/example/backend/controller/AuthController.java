package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.TokenResponse;
import com.example.backend.dto.UserResponse;
import com.example.backend.security.JwtUtils;
import com.example.backend.service.UserService;

import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.authenticate(loginRequest, manager, jwtUtils);
        return ResponseEntity.ok(new TokenResponse(token));
    }
    

}
