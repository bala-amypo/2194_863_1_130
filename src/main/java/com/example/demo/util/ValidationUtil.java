package com.example.demo.util;

public final class ValidationUtil {

    private ValidationUtil() {
        // Prevent object creation
    }

    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    /**
     * Validate password strength
     * Minimum 6 characters
     */
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    /**
     * Validate non-empty string
     */
    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Validate positive ID
     */
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}
