package com.globeshanghai.backend.dto;

import com.globeshanghai.backend.dom.event.ShortEvent;

import java.util.List;

/**
 * Created by stijnergeerts on 23/04/17.
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

    public UserDTO(String username, String authId, String firstname, String lastname, List<ShortEvent> userEvents) {
        this.username = username;
        this.authId = authId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEvents = userEvents;
    }

    public UserDTO(String userId, String username, String authId, String firstname, String lastname, List<ShortEvent> userEvents) {
        this.userId = userId;
        this.username = username;
        this.authId = authId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEvents = userEvents;
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
