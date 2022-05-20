package com.novisign.task.API.Service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String cause) {
        super("User not found with " + cause);
    }
}
