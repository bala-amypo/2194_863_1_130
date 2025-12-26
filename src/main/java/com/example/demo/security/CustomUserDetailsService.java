package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // TEMP user for compilation (replace with DB later)
        return new User(
                email,
                "{noop}password",
                Collections.emptyList()
        );
    }
}
