package com.globeshanghai.backend.repositories;

import com.globeshanghai.backend.dom.user.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by stijnergeerts on 23/04/17.
 */
public interface UserRepository extends Repository<User, String> {

    void delete(User deleted);

    List<User> findAll();

    Optional<User> findOne(String id);

    User findUserByAuthId(String authId);

    User findUserByUsername(String username);

    User save(User saved);

}
