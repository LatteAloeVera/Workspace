package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.UserResponse;
import com.example.backend.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private String username(UserDetails principal) {
        return principal.getUsername();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id, @AuthenticationPrincipal UserDetails principal) {
        return ResponseEntity.ok(userService.getUser(id, username(principal)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateById(@PathVariable Long id, @RequestBody RegisterRequest request,
            @AuthenticationPrincipal UserDetails principal) {
        return ResponseEntity.ok(userService.updateUser(id, request, username(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id, @AuthenticationPrincipal UserDetails principal) {
        userService.deleteUser(id, username(principal));
        return ResponseEntity.noContent().build();
    }

}
