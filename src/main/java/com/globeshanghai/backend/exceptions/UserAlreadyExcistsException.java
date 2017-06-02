package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 3/05/17.
 */
public class UserAlreadyExcistsException extends RuntimeException {

    /**
     * This exception is thrown when there already exists a {@link com.globeshanghai.backend.dom.user.User} with that userName.
     * @param username The userName that already exists.
     */
    public UserAlreadyExcistsException(String username) {
        super(String.format("User with username: <%s> already exists", username));
    }
}
