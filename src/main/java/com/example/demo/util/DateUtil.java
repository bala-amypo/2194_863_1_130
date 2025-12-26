package com.example.demo.util;

import java.time.LocalDate;

public class DateUtil {
    public static boolean isExpired(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }
}
