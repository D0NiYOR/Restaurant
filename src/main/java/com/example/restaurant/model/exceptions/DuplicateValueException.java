package com.example.restaurant.model.exceptions;

public class DuplicateValueException extends RuntimeException{

    public DuplicateValueException(String message) {
        super(message);
    }
}