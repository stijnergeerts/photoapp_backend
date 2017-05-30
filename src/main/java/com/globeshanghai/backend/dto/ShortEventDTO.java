package com.globeshanghai.backend.dto;

/**
 * This data transfer object contains the information of a single shortEvent
 * entry and specifies validation rules that are used to ensure that only
 * valid information can be saved to the used database.
 */
public class ShortEventDTO {
    private String eventId;

    private String eventName;

    private String eventLogo;

    public ShortEventDTO(String eventId, String eventName, String eventLogo) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLogo = eventLogo;
    }

    public ShortEventDTO(String eventName, String eventLogo) {
        this.eventName = eventName;
        this.eventLogo = eventLogo;
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

    public String getEventLogo() {
        return eventLogo;
    }

    public void setEventLogo(String eventLogo) {
        this.eventLogo = eventLogo;
    }
}
