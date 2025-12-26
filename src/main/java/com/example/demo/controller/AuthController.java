package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
public class AuthController {

    @GetMapping("/auth")
    public AuthResponse getAuth() {
        return new AuthResponse("user1", 1L, "user1@example.com", Set.of("ROLE_USER"));
    }
}
