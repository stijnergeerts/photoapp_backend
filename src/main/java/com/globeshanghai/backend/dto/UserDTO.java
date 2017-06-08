package com.globeshanghai.backend.dto;

import com.globeshanghai.backend.dom.event.ShortEvent;

import java.util.List;

/**
 * This data transfer object contains the information of a single user
 * entry and specifies validation rules that are used to ensure that only
 * valid information can be saved to the used database.
 */
public class UserDTO {
    private String userId;

    private String username;

    private String authId;

    private String firstname;

    private String lastname;

    private List<ShortEvent> userEvents;

    public UserDTO() {
    }

    public UserDTO(UserDTO userEntry) {
        this.userId = userEntry.getUserId();
        this.username = userEntry.getUsername();
        this.authId = userEntry.getAuthId();
        this.firstname = userEntry.getFirstname();
        this.lastname = userEntry.getLastname();
        this.userEvents = userEntry.getUserEvents();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<ShortEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<ShortEvent> userEvents) {
        this.userEvents = userEvents;
    }
}
