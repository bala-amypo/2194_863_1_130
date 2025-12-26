package com.example.demo.dto;

import java.util.Set;

public class AuthResponse {
    private String username;
    private Long id;
    private String email;
    private Set<String> roles;

    public AuthResponse() {}

    public AuthResponse(String username, Long id, String email, Set<String> roles) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
