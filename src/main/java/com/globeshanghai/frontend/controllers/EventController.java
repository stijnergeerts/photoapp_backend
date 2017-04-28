package com.globeshanghai.frontend.controllers;

import com.auth0.jwt.JWT;
import com.globeshanghai.backend.dom.event.ShortEvent;
import com.globeshanghai.backend.dto.EventDTO;
import com.globeshanghai.backend.dto.UserDTO;
import com.globeshanghai.backend.exceptions.EventNotFoundException;
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
 * Created by stijnergeerts on 20/04/17.
 */
@RestController
@RequestMapping("api/event")
final class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;
    private final UserService userService;

    @Autowired
    EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @RequestMapping(value = "/createEvent",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EventDTO create(@RequestHeader("token") String token, @RequestBody @Valid EventDTO eventEntry) {
        LOGGER.info("Creating a new event entry with information: {}", eventEntry);
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        EventDTO created = eventService.create(eventEntry);
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        userEvents.add(new ShortEvent(created.getEventId(),created.getEventName(),created.getOverviewLayout().getBackgroundImage()));
        userEntry.setUserEvents(userEvents);
        userService.update(userEntry);
        LOGGER.info("Created a new event entry with information: {}", created);

        return created;
    }

    @RequestMapping(value = "/deleteEvent/{id}", method = RequestMethod.DELETE)
    EventDTO delete(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Deleting event entry with id: {}", id);
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventIds = new LinkedList<>();
        for (int i=0; i<userEvents.size(); i++){
            eventIds.add(userEvents.get(i).getEventId());
        }
        if (!eventIds.contains(id))
            throw new EventNotFoundException("Event with ID "+ id +" not found!");
        EventDTO deleted = eventService.delete(id);
        for (int i=0; i<userEvents.size(); i++){
            if (deleted.getEventId()==userEvents.get(i).getEventId())
                userEvents.remove(userEvents.get(i));
        }
        userEntry.setUserEvents(userEvents);
        userService.update(userEntry);
        LOGGER.info("Deleted event entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    List<EventDTO> findAll(@RequestHeader("token") String token) {
        LOGGER.info("Finding all event entries");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<EventDTO> eventEntries = new LinkedList<>();
        for (int i = 0; i<userEvents.size();i++){
            eventEntries.add(i,eventService.findById(userEvents.get(i).getEventId()));
        }

        return eventEntries;

    }

    @RequestMapping(value = "/getEvent/{id}", method = RequestMethod.GET)
    EventDTO findById(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Finding event entry with id: {}", id);
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventIds = new LinkedList<>();
        for (int i=0; i<userEvents.size(); i++){
            eventIds.add(userEvents.get(i).getEventId());
        }
        if (!eventIds.contains(id))
            throw new EventNotFoundException("Event with ID "+ id +" not found!");
        EventDTO eventEntry = eventService.findById(id);
        LOGGER.info("Found event entry with information: {}", eventEntry);

        return eventEntry;
    }

    @RequestMapping(value = "/updateEvent", method = RequestMethod.PUT)
    EventDTO update(@RequestHeader("token") String token, @RequestBody @Valid EventDTO eventEntry) {
        LOGGER.info("Updating event entry with information: {}", eventEntry);
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventIds = new LinkedList<>();
        for (int i=0; i<userEvents.size(); i++){
            eventIds.add(userEvents.get(i).getEventId());
        }
        if (!eventIds.contains(eventEntry.getEventId()))
            throw new EventNotFoundException("Event with ID "+ eventEntry.getEventId() +" not found!");
        EventDTO updated = eventService.update(eventEntry);
        LOGGER.info("Updated event entry with information: {}", updated);

        return updated;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(EventNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
