package com.globeshanghai.backend.repositories;

import com.globeshanghai.backend.dom.user.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


/**
 * This repository provides CRUD operations for {@link com.globeshanghai.backend.dom.user.User} objects.
 */
public interface UserRepository extends Repository<User, String> {

    /**
     * Deletes a user entry from the database.
     * @param deleted   The deleted user entry.
     */
    void delete(User deleted);

    /**
     * Finds all user entries from the database.
     * @return  The information of all user entries that are found from the database.
     */
    List<User> findAll();

    /**
     * Finds the information of a single user entry.
     * @param id    The id of the requested user entry.
     * @return      The information of the found user entry. If no event entry
     *              is found, this method returns an empty {@link java.util.Optional} object.
     */
    Optional<User> findOne(String id);

    /**
     * Finds the information of a single user entry.
     * @param authId    The authId of the requested event entry.
     * @return          The information of the found event entry. If no event entry
     *                  is found, this method returns an empty {@link com.globeshanghai.backend.dom.user.User} object.
     */
    User findUserByAuthId(String authId);

    /**
     * Finds the information of a single user entry.
     * @param username  The userName of the requested event entry.
     * @return          The information of the found event entry. If no event entry
     *                  is found, this method returns an {@link com.globeshanghai.backend.dom.user.User} object.
     */
    User findUserByUsername(String username);

    /**
     * Saves a new user entry to the database.
     * @param saved The information of the saved user entry.
     * @return      The information of the saved user entry.
     */
    User save(User saved);

}
