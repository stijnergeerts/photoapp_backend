package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 19/04/17.
 */
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String id) {
        super(String.format("No event entry found with id: <%s>", id));
    }
}
