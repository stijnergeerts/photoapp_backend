package com.globeshanghai.frontend.controllers;

import com.auth0.jwt.JWT;
import com.globeshanghai.backend.dom.event.ShortEvent;
import com.globeshanghai.backend.dto.UserDTO;
import com.globeshanghai.backend.exceptions.UserAlreadyExcistsException;
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

@RestController
@CrossOrigin
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

    /**
     * Create a {@link com.globeshanghai.backend.dom.user.User}.
     * @param token Token
     * @param userEntry UserDTO
     * @return HTTP Status Created
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<?> create( @RequestHeader("token") String token, @RequestBody @Valid UserDTO userEntry) {
        LOGGER.info("Creating a new user entry with information: {}", userEntry);
        List<UserDTO> userDTOS = userService.findAll();
        userEntry.setAuthId(JWT.decode(token).getSubject());
        for (UserDTO userDTO : userDTOS){
            if (userDTO.getUsername().equals(userEntry.getUsername())||userDTO.getAuthId().equals(userEntry.getAuthId())) {
                return new ResponseEntity("A User with username: " + userEntry.getUsername() + " already exists!",
                        HttpStatus.CONFLICT
                );
            }
        }
        userEntry.setUserEvents(new LinkedList<>());
        userService.create(userEntry);
        LOGGER.info("Created a new user entry with information: {}", userEntry);

        return new ResponseEntity<UserDTO>(new UserDTO(userEntry), HttpStatus.CREATED);
    }

    /**
     * Delete a specific {@link com.globeshanghai.backend.dom.user.User}.
     * @param token Token
     * @param id User userId
     * @return HTTP status OK
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Deleting user entry with authId: {}", JWT.decode(token).getSubject());
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<ShortEvent> userEvents = userEntry.getUserEvents();
        for (int i = 0; i<userEvents.size(); i++){
            eventService.delete(userEvents.get(i).getEventId());
        }
        UserDTO deleted = userService.delete(id);
        LOGGER.info("Deleted user entry with information: {}", deleted);

        return new ResponseEntity<UserDTO>(new UserDTO(userEntry), HttpStatus.OK);
    }

    /**
     * Delete a specific {@link com.globeshanghai.backend.dom.event.Event} based on authId
     * @param token Token
     * @return HTTP status OK
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestHeader("token") String token) {
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

        return new  ResponseEntity<UserDTO>(new UserDTO(userEntry), HttpStatus.OK);
    }

    /**
     * Get all {@link com.globeshanghai.backend.dom.user.User}
     * @param token
     * @return all {@link com.globeshanghai.backend.dto.UserDTO} entries
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestHeader("token") String token) {
        LOGGER.info("Finding all user entries");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        List<UserDTO> userEntries = userService.findAll();

        return new ResponseEntity<List<UserDTO>>(userEntries, HttpStatus.OK);

    }

    /**
     * Get a specific {@link com.globeshanghai.backend.dom.user.User} based on authId
     * @param token Token
     * @return UserDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByAuthId(@RequestHeader("token") String token) {
        LOGGER.info("Finding user entry with authId: {}");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        LOGGER.info("Found user entry with information: {}", userEntry);

        return new ResponseEntity<UserDTO>(userEntry, HttpStatus.OK);
    }

    /**
     * Get a specific {@link com.globeshanghai.backend.dom.user.User} based on userId
     * @param token Token
     * @return UserDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@RequestHeader("token") String token, @PathVariable("id") String id) {
        LOGGER.info("Finding user entry with id: {}");
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        UserDTO userDTO = userService.findById(id);
        LOGGER.info("Found user entry with information: {}", userEntry);

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

    /**
     * Update an existing {@link com.globeshanghai.backend.dom.user.User}.
     * @param token Token
     * @param userDTO UserDTO
     * @return HTTP status OK
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestHeader("token") String token, @RequestBody @Valid UserDTO userDTO) {
        UserDTO userEntry = userService.findUserByAuthId(JWT.decode(token).getSubject());
        if (userEntry == null)
            throw  new UserNotFoundException("User with token " + JWT.decode(token).getSubject() + " not found!");
        LOGGER.info("Updating user entry with information: {}", userDTO);
        List<UserDTO> userDTOS = userService.findAll();
        if (userDTO.getUserEvents()==null){
            userDTO.setUserEvents(new LinkedList<>());
        }
        if (!userDTO.getUsername().equals(userEntry.getUsername())) {
            if (this.userService.findUserByUsername(userDTO.getUsername()) != null) {
                return new ResponseEntity(new UserAlreadyExcistsException("Could not update User! Username " + userDTO.getUsername() + " already exists!"),
                        HttpStatus.CONFLICT
                );
            }
        }
        UserDTO updated = userService.update(userDTO);
        LOGGER.info("Updated user entry with information: {}", updated.getUsername());

        return new ResponseEntity<UserDTO>(updated, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
