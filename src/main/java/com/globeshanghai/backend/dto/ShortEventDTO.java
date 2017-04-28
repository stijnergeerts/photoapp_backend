package com.globeshanghai.backend.dto;

/**
 * Created by stijnergeerts on 27/04/17.
 */
public class ShortEventDTO {
    private String eventId;

    private String eventName;

    public ShortEventDTO(String eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public ShortEventDTO(String eventName) {
        this.eventName = eventName;
    }

    public ShortEventDTO() {
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
