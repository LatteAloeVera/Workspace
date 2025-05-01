package com.example.backend.service;

import com.example.backend.dto.*;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(RegisterRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new IllegalStateException("Email already taken");
        });

        userRepository.findByUsername(request.getUsername()).ifPresent(user -> {
            throw new IllegalStateException("Username already taken");
        });

        User saved = userRepository.save(new User(null,
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())));

        return new UserResponse(saved.getId(), saved.getUsername(), saved.getEmail());
    }

    // --- Authentication ----------------------------------------------------
    public String authenticate(LoginRequest req, AuthenticationManager manager, JwtUtils jwt) {
        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return jwt.generateToken(userDetails);
    }

    // --- Read current user --------------------------------------------------
    public UserResponse getByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    // --- Read by id (self only) -------------------------------------------
    public UserResponse getUser(Long id, String requester) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        ensureSelf(user, requester);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    // --- Update ------------------------------------------------------------
    public UserResponse updateUser(Long id, RegisterRequest req, String requester) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        ensureSelf(user, requester);
        
        userRepository.findByUsername(req.getUsername()).filter(u -> !u.getId().equals(user.getId())).ifPresent(u -> {
            throw new IllegalStateException("Username already taken");
        });

        userRepository.findByEmail(req.getEmail()).filter(u -> !u.getId().equals(user.getId())).ifPresent(u -> {
            throw new IllegalStateException("Email already taken");
        });
        
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        if (req.getPassword() != null && !req.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(req.getPassword()));
        }
        User updated = userRepository.save(user);
        return new UserResponse(updated.getId(), updated.getUsername(), updated.getEmail());
    }

    // --- Delete ------------------------------------------------------------
    public void deleteUser(Long id, String requester) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        ensureSelf(user, requester);
        userRepository.delete(user);
    }

    private void ensureSelf(User user, String requester) {
        if (!user.getUsername().equals(requester)) {
            throw new AccessDeniedException("You are not allowed to access this resource");
        }
    }

}
