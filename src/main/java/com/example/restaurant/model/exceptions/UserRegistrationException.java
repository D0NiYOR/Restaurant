package com.example.restaurant.model.exceptions;

public class UserRegistrationException extends RuntimeException{
    public UserRegistrationException(String msg) {
        super(msg);
    }
}
