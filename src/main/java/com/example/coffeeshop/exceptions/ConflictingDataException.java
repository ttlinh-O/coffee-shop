package com.example.coffeeshop.exceptions;

public class ConflictingDataException extends RuntimeException {
    public ConflictingDataException(String message) {
        super(message);
    }

    public ConflictingDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
