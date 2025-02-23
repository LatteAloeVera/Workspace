package com.example.library.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.library.dto.*;
import com.example.library.model.*;
import com.example.library.security.*;
import com.example.library.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(User.Role.USER);
        authService.register(user);

        return "user registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = authService.login(request.getUsername(), request.getPassword());
        if (user == null) {
            return new AuthResponse("Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().toString());
        return new AuthResponse(token);
    }
}