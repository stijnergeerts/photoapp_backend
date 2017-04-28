package com.globeshanghai.frontend.controllers;

import com.auth0.jwt.JWT;
import com.globeshanghai.backend.dom.event.ShortEvent;
import com.globeshanghai.backend.dto.UserDTO;
import com.globeshanghai.backend.exceptions.UserNotFoundException;
import com.globeshanghai.backend.services.EventService;
import com.globeshanghai.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stijnergeerts on 23/04/17.
 */
@RestController
@RequestMapping("api/user")
final class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final UserService userService;
    private final EventService eventService;

    @Autowired
    UserController(UserService service, EventService eventService) {
        this.userService = service;
        this.eventService = eventService;
    }


    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO create( @RequestHeader("token") String token, @RequestBody @Valid UserDTO userEntry) {
        LOGGER.info("Creating a new user entry with information: {}", userEntry);
        userEntry.setAuthId(JWT.decode(token).getSubject());
        userEntry.setUserEvents(new LinkedList<>());
        UserDTO created = userService.create(userEntry);
        LOGGER.info("Created a new user entry with information: {}", created);

        return created;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    UserDTO delete(@RequestHeader("token") String token) {
        LOGGER.info("Deleting user entry with authId: {}", JWT.decode(token).getSubject());
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        for (int i = 0; i<userEvents.size(); i++){
            eventService.delete(userEvents.get(i).getEventId());
        }
        UserDTO deleted = userService.delete(userEntry.getUserId());
        LOGGER.info("Deleted user entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    List<UserDTO> findAll(@RequestHeader("token") String token) {
        LOGGER.info("Finding all user entries");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<UserDTO> eventEntries = userService.findAll();

        return eventEntries;

    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    UserDTO findById(@RequestHeader("token") String token) {
        LOGGER.info("Finding user entry with id: {}");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        LOGGER.info("Found user entry with information: {}", userEntry);

        return userEntry;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    UserDTO update(@RequestHeader("token") String token, @RequestBody @Valid UserDTO eventEntry) {
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        LOGGER.info("Updating user entry with information: {}", eventEntry);
        UserDTO updated = userService.update(eventEntry);
        LOGGER.info("Updated user entry with information: {}", updated);

        return updated;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
