package com.globeshanghai.backend.services;

import com.globeshanghai.backend.dto.UserDTO;

import java.util.List;

/**
 * Created by stijnergeerts on 23/04/17.
 */
public interface UserService {
    UserDTO create(UserDTO user);

    UserDTO delete(String id);

    List<UserDTO> findAll();

    UserDTO findById(String id);

    UserDTO findUserByAuthId(String authId);

    UserDTO update(UserDTO user);
}
