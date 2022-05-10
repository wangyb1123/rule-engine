package com.everest.rule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static LocalDate stringToDate(String date, DateTimeFormatter pattern) {
        return LocalDate.parse(date, pattern);
    }

    public static LocalDate stringToDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return stringToDate(date, formatter);
    }
}
