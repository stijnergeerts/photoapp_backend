package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 23/04/17.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * This exception is thrown when no content is found.
     * @param id The userId that is not linked to a {@link com.globeshanghai.backend.dom.user.User}
     */
    public UserNotFoundException(String id) {
        super(String.format("No user entry found with id: <%s>", id));
    }
}
