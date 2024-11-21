package com.example.dx_admindashboard.exception;

public record ErrorDTO(
        String errorMessage
) {
    public static ErrorDTO of(String errorMessage) {
        return new ErrorDTO(errorMessage);
    }
}
