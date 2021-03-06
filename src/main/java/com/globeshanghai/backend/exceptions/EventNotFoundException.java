package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 19/04/17.
 */
public class EventNotFoundException extends RuntimeException {

    /**
     * This exception is thrown when no content is found.
     * @param id The eventId that is not linked to a {@link com.globeshanghai.backend.dom.event.Event}
     */
    public EventNotFoundException(String id) {
        super(String.format("No event entry found with id: <%s>", id));
    }
}
