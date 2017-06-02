package com.globeshanghai.backend.mongorepositories;

import com.globeshanghai.backend.dom.user.User;
import com.globeshanghai.backend.dto.UserDTO;
import com.globeshanghai.backend.exceptions.UserNotFoundException;
import com.globeshanghai.backend.repositories.UserRepository;
import com.globeshanghai.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MongoDBUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    MongoDBUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a {@link com.globeshanghai.backend.dom.user.User}.
     * @param user UserDTO
     * @return UserDTO
     */
    @Override
    public UserDTO create(UserDTO user) {
        User persisted =  User.getBuilder()
                .username(user.getUsername())
                .authId(user.getAuthId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .userEvents(user.getUserEvents())
                .build();
        userRepository.save(persisted);
        return convertToDTO(persisted);
    }

    /**
     * Delete a {@link com.globeshanghai.backend.dom.user.User}.
     * @param id User userId
     * @return UserDTO
     */
    @Override
    public UserDTO delete(String id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return convertToDTO(user);
    }

    /**
     * Find all {@link com.globeshanghai.backend.dom.user.User}.
     * @return List of UserDTO
     */
    @Override
    public List<UserDTO> findAll() {
        List<User> configurationEntries = userRepository.findAll();
        return convertToDTOs(configurationEntries);
    }

    /**
     * Find a {@link com.globeshanghai.backend.dom.user.User}.
     * @param id User userId
     * @return UserDTO
     */
    @Override
    public UserDTO findById(String id) {
        return null;
    }

    /**
     * Find a {@link com.globeshanghai.backend.dom.user.User}.
     * @param authId User authId
     * @return UserDTO
     */
    @Override
    public UserDTO findUserByAuthId(String authId) {
        List<User> users = userRepository.findAll();
        for (User user : users){
            if (user.getAuthId().equals(authId)){
                return convertToDTO(user);
            }
        }
        return null;
    }

    /**
     * Find a {@link com.globeshanghai.backend.dom.user.User}.
     * @param username User username
     * @return UserDTO
     */
    @Override
    public UserDTO findUserByUsername(String username) {
        List<User> users = userRepository.findAll();
        for (User user : users){
            if (user.getUsername().equals(username)){
                return convertToDTO(user);
            }
        }
        return null;
    }

    /**
     * Update an existing {@link com.globeshanghai.backend.dom.user.User}.
     * @param user User
     * @return UserDTO
     */
    @Override
    public UserDTO update(UserDTO user) {

        User updated = findUserById(user.getUserId());
        updated.update(user.getUsername(), user.getAuthId(), user.getFirstname(),user.getLastname(),user.getUserEvents());
        updated = userRepository.save(updated);
        return convertToDTO(updated);
    }

    /**
     * Convert a {@link com.globeshanghai.backend.dom.user.User} to a {@link com.globeshanghai.backend.dto.UserDTO}
     * @param model User
     * @return UserDTO
     */
    private UserDTO convertToDTO(User model) {
        UserDTO dto = new UserDTO();
        dto.setUserId(model.getUserId());
        dto.setUsername(model.getUsername());
        dto.setAuthId(model.getAuthId());
        dto.setFirstname(model.getFirstname());
        dto.setLastname(model.getLastname());
        dto.setUserEvents(model.getUserEvents());
        return dto;
    }

    /**
     * Convert a list of {@link com.globeshanghai.backend.dom.user.User} to a list of {@link com.globeshanghai.backend.dto.UserDTO}
     * @param models List of Event
     * @return EventDTO
     */
    private List<UserDTO> convertToDTOs(List<User> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private User findUserById(String id) {
        Optional<User> result = userRepository.findOne(id);
        return result.orElseThrow(() -> new UserNotFoundException(id));

    }
}
