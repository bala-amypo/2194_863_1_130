package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    User getById(Long id);
    User getByEmail(String email);
    List<User> getAll();
}
