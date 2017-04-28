package com.globeshanghai.backend.dom.event;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by stijnergeerts on 28/04/17.
 */

@Document(collection = "shortevent")
public final class ShortEvent {

    private String eventId;

    private String eventName;

    private String eventImage;

    public ShortEvent(String eventId, String eventName, String eventImage) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventImage = eventImage;
    }

    public ShortEvent() {
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

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }
}
