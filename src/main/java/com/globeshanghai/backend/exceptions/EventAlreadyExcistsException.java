package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 4/05/17.
 */
public class EventAlreadyExcistsException extends RuntimeException {
    public EventAlreadyExcistsException(String eventName) {
        super(String.format("Event with this name already excists: <%s>", eventName));
    }
}
