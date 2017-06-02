package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 4/05/17.
 */
public class EventAlreadyExcistsException extends RuntimeException {

    /**
     * This exception is thrown when there already exists a {@link com.globeshanghai.backend.dom.event.Event} with that eventName.
     * @param eventName The eventName that already exists.
     */
    public EventAlreadyExcistsException(String eventName) {
        super(String.format("Event with this name already excists: <%s>", eventName));
    }
}
