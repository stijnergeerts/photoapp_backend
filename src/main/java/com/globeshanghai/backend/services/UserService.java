package com.globeshanghai.backend.services;

import com.globeshanghai.backend.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO user);

    UserDTO delete(String id);

    UserDTO findById(String id);

    List<UserDTO> findAll();

    UserDTO findUserByAuthId(String authId);

    UserDTO findUserByUsername(String username);

    UserDTO update(UserDTO user);
}
