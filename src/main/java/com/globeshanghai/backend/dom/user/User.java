package com.globeshanghai.backend.dom.user;

import com.globeshanghai.backend.dom.event.ShortEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

import static com.globeshanghai.frontend.util.PreCondition.notEmpty;
import static com.globeshanghai.frontend.util.PreCondition.notNull;

/**
 * Created by stijnergeerts on 23/04/17.
 */
@Document(collection = "user")
public final class User implements Serializable {

    @Id
    private String userId;

    private String username;

    private String authId;

    private String firstname;

    private String lastname;

    private List<ShortEvent> userEvents;

    private User(Builder builder) {
        this.username = builder.username;
        this.authId = builder.authId;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.userEvents = builder.userEvents;
    }

    public User() {
    }

    public User(String username, String authId, String firstname, String lastname, List<ShortEvent> userEvents) {
        this.username = username;
        this.authId = authId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEvents = userEvents;
    }

    public static User.Builder getBuilder() {
        return new User.Builder();
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

    public void setUserEvents(List<ShortEvent> eventIds) {
        this.userEvents = userEvents;
    }

    public void update(String username, String authId, String firstname, String lastname, List<ShortEvent> userEvents) {
        checkAll(username, authId, firstname, lastname, userEvents);

        this.username = username;
        this.authId = authId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEvents = userEvents;
    }

    /**
     * Using the builder pattern because we are creating a complex object.
     * This makes the code clearer and easier to read.
     */
    public static class Builder {

        private String username;

        private String authId;

        private String firstname;

        private String lastname;

        private List<ShortEvent> userEvents;


        private Builder() {}

        public User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public User.Builder authId(String authId) {
            this.authId = authId;
            return this;
        }

        public User.Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public User.Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public User.Builder userEvents(List<ShortEvent> userEvents) {
            this.userEvents = userEvents;
            return this;
        }

        /**
         * Building the actual {@link com.globeshanghai.backend.dom.user.User} object.
         * @return {@link com.globeshanghai.backend.dom.user.User}
         */
        public User build() {
            User build = new User(this);

            build.checkAll(build.getUsername(), build.getAuthId(),
                    build.getFirstname(), build.getLastname(),build.getUserEvents());

            return build;
        }
    }

    /**
     * If there are variables that can't be empty or null, it can be checked in this method using the
     * {@link com.globeshanghai.frontend.util.PreCondition} notNull and notEmpty methods
     */
    private void checkAll(String username, String authId, String firstname, String lastname, List<ShortEvent> userEvents) {
        notNull(username, "username cannot be null");
        notEmpty(username, "username cannot be empty");

        notNull(authId, "authId cannot be null");

        notNull(firstname, "firstname cannot be null");
        notEmpty(firstname, "firstname cannot be empty");

        notNull(lastname, "lastname cannot be null");
        notEmpty(lastname, "lastname cannot be empty");


    }

}
