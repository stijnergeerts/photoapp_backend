package com.globeshanghai.frontend.controllers;

import com.auth0.jwt.JWT;
import com.globeshanghai.backend.dom.event.ShortEvent;
import com.globeshanghai.backend.dto.EventDTO;
import com.globeshanghai.backend.dto.UserDTO;
import com.globeshanghai.backend.exceptions.EventAlreadyExcistsException;
import com.globeshanghai.backend.exceptions.EventNotFoundException;
import com.globeshanghai.backend.exceptions.UserNotFoundException;
import com.globeshanghai.backend.services.EventService;
import com.globeshanghai.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stijnergeerts on 20/04/17.
 */
@RestController
@CrossOrigin
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

    /**
     * Create a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param token Token
     * @param eventEntry Event
     * @return EventDTO
     * @return HTTP Status Created
     */
    @RequestMapping(value = "/createEvent",method = RequestMethod.POST)
    ResponseEntity<?> create(@RequestHeader("token") String token, @RequestBody @Valid EventDTO eventEntry) {
        LOGGER.info("Creating a new event entry with information: {}", eventEntry);

        /* Check if the user is authorised */
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        List<ShortEvent> shortEvents = new LinkedList<>();
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        for (ShortEvent shortEvent : userEntry.getUserEvents()){
            if (shortEvent.getEventName().equals(eventEntry.getEventName())){
                return new ResponseEntity("A Event with name " + eventEntry.getEventName()+" already exists!",
                        HttpStatus.CONFLICT
                );
            }
        }
        EventDTO created = eventService.create(eventEntry);
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        userEvents.add(new ShortEvent(created.getEventId(),created.getEventName(),created.getEventLogo()));
        userEntry.setUserEvents(userEvents);
        userService.update(userEntry);
        LOGGER.info("Created a new event entry with information: {}", created);

        return new ResponseEntity<EventDTO>(created, HttpStatus.CREATED);
    }

    /**
     * Delete a specific {@link com.globeshanghai.backend.dom.event.Event}.
     * @param token Token
     * @param id Event eventId
     * @return HTTP status OK
     */
    @RequestMapping(value = "/deleteEventById/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteById(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Deleting event entry with id: {}", id);

        /* Check if the user is authorised */
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
            if (deleted.getEventId().equals(userEvents.get(i).getEventId())) {
                userEvents.remove(userEvents.get(i));
            }
        }
        userEntry.setUserEvents(userEvents);
        userService.update(userEntry);
        LOGGER.info("Deleted event entry with information: {}", deleted.getEventName());

        return new ResponseEntity<EventDTO>(deleted, HttpStatus.OK);
    }

    /**
     * Delete a specific {@link com.globeshanghai.backend.dom.event.Event}.
     * @param token Token
     * @param eventName Event eventName
     * @return HTTP status OK
     */
    @RequestMapping(value = "/deleteEventByName/{eventName}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteByName(@RequestHeader("token") String token, @PathVariable("eventName") String eventName) {
        LOGGER.info("Deleting event entry with id: {}", eventName);

        /* Check if the user is authorised */
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventNames = new LinkedList<>();
        for (int i=0; i<userEvents.size(); i++){
            eventNames.add(userEvents.get(i).getEventName());
        }
        if (!eventNames.contains(eventName))
            throw new EventNotFoundException("Event with name "+ eventName +" not found!");
        EventDTO deleted = eventService.deleteByEventName(eventName);
        for (int i=0; i<userEvents.size(); i++){
            if (deleted.getEventId().equals(userEvents.get(i).getEventId())) {
                userEvents.remove(userEvents.get(i));
            }
        }
        userEntry.setUserEvents(userEvents);
        userService.update(userEntry);
        LOGGER.info("Deleted event entry with information: {}", deleted.getEventName());

        return new ResponseEntity<EventDTO>(deleted, HttpStatus.OK);
    }

    /**
     * Get all {@link com.globeshanghai.backend.dom.event.Event} entries from a certain {@link com.globeshanghai.backend.dom.user.User}
     * @param token
     * @return all {@link com.globeshanghai.backend.dto.EventDTO} entries
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    ResponseEntity<?> findAll(@RequestHeader("token") String token) {
        LOGGER.info("Finding all event entries");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<EventDTO> eventEntries = new LinkedList<>();
        for (int i = 0; i<userEvents.size();i++){
            eventEntries.add(i,eventService.findById(userEvents.get(i).getEventId()));
        }

        return new  ResponseEntity<List<EventDTO>>(eventEntries, HttpStatus.OK);

    }

    /**
     * Get a specific {@link com.globeshanghai.backend.dom.event.Event} from a {@link com.globeshanghai.backend.dom.user.User}.
     * @param token Token
     * @param id Event id
     * @return EventDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getEventById/{id}", method = RequestMethod.GET)
    ResponseEntity<?> findById(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Finding event entry with id: {}", id);

        /* Check if the user is authorised */
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
        LOGGER.info("Found event entry with information: {}", eventEntry.getEventName());

        return new ResponseEntity<EventDTO>(eventEntry, HttpStatus.OK);
    }

    /**
     * Get a specific {@link com.globeshanghai.backend.dom.event.Event} from a {@link com.globeshanghai.backend.dom.user.User}.
     * @param token Token
     * @param eventName Event eventName
     * @return EventDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getEventByName/{eventName}", method = RequestMethod.GET)
    ResponseEntity<?> findByEventName(@RequestHeader("token") String token, @PathVariable("eventName") String eventName) {
        LOGGER.info("Finding event entry with name: {}", eventName);

        /* Check if the user is authorised */
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventIds = new LinkedList<>();
        for (int i=0; i<userEvents.size(); i++){
            eventIds.add(userEvents.get(i).getEventName());
        }
        if (!eventIds.contains(eventName))
            throw new EventNotFoundException("Event with name "+ eventName +" not found!");
        EventDTO eventEntry = eventService.findByEventName(eventName);
        LOGGER.info("Found event entry with information: {}", eventEntry.getEventName());

        return new ResponseEntity<EventDTO>(eventEntry, HttpStatus.OK);
    }

    /**
     * Get a specific {@link com.globeshanghai.backend.dom.event.Event}
     * @param id Event eventId
     * @return EventDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getEventShareById/{id}", method = RequestMethod.GET)
    ResponseEntity<?> findEventShareById(@RequestHeader("token") String token,@PathVariable("id") String id) {
        LOGGER.info("Finding event entry with id: {}", id);

        /* Check if the user is authorised */
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<EventDTO> events = eventService.findAll();
        EventDTO eventDTO = new EventDTO();
        for (int i=0; i<events.size(); i++){
            if (events.get(i).getEventId().equals(id)){
                eventDTO=events.get(i);
            }
        }
        if (eventDTO.getEventId()==null){
            throw new EventNotFoundException("Event with id "+ id +" not found!");
        }

        return new ResponseEntity<EventDTO>(eventDTO, HttpStatus.OK);
    }

    /**
     * Update an existing {@link com.globeshanghai.backend.dom.event.Event}.
     * @param token Token
     * @param eventEntry EventDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/updateEvent", method = RequestMethod.PUT)
    ResponseEntity<?> update(@RequestHeader("token") String token, @RequestBody @Valid EventDTO eventEntry) {
        LOGGER.info("Updating event entry with information: {}", eventEntry);

        /* Check if the user is authorised */
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        EventDTO currentEvent = eventService.findById(eventEntry.getEventId());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        List<String> eventIds = new LinkedList<>();
        if (!currentEvent.getEventName().equals(eventEntry.getEventName())) {
            for (ShortEvent shortEvent : userEntry.getUserEvents()) {
                if (shortEvent.getEventName().equals(eventEntry.getEventName())) {
                        return new ResponseEntity(new EventAlreadyExcistsException(eventEntry.getEventName()),
                                HttpStatus.CONFLICT
                        );
                }
            }
        }
        for (ShortEvent userEvent : userEvents) {
            eventIds.add(userEvent.getEventId());
        }
        updateUserEvents(eventEntry.getEventId(),eventEntry.getEventName(),eventEntry.getEventLogo(), userEntry);
        if (!eventIds.contains(eventEntry.getEventId()))
            throw new EventNotFoundException("Event with ID "+ eventEntry.getEventId() +" not found!");
        userService.update(userEntry);
        EventDTO updated = eventService.update(eventEntry);
        LOGGER.info("Updated event entry with information: {}", updated);

        return new ResponseEntity<EventDTO>(updated, HttpStatus.OK);
    }

    /**
     * Update an the {@link com.globeshanghai.backend.dom.event.ShortEvent} of a {@link com.globeshanghai.backend.dom.user.User}.
     * @param userEventId Event eventId
     * @param userEventName Event eventName
     * @param userEventLogo Event eventLogo
     * @param userEntry UserDTO
     */
    public void updateUserEvents(String userEventId, String userEventName, String userEventLogo, UserDTO userEntry){
        List<ShortEvent> shortEvents = new LinkedList<>();
        shortEvents = userEntry.getUserEvents();
        for (int i = 0; i < shortEvents.size(); i++){
            if (userEventId.equals(shortEvents.get(i).getEventId())){
                shortEvents.get(i).setEventId(userEventId);
                shortEvents.get(i).setEventName(userEventName);
                shortEvents.get(i).setEventLogo(userEventLogo);
            }
        }
        userEntry.setUserEvents(shortEvents);
        userService.update(userEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEventNotFound(EventNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
