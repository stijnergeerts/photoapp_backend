package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 3/05/17.
 */
public class UserAlreadyExcistsException extends RuntimeException {
    public UserAlreadyExcistsException(String username) {
        super(String.format("User with username: <%s> already exists", username));
    }
}
