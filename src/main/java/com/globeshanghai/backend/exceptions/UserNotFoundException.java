package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 23/04/17.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(String.format("No user entry found with id: <%s>", id));
    }
}
