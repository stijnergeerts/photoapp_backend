package com.globeshanghai.backend.repositories;

import com.globeshanghai.backend.dom.event.Event;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by stijnergeerts on 20/04/17.
 */
public interface EventRepository extends Repository<Event, String> {

    void delete(Event deleted);

    List<Event> findAll();

    Optional<Event> findOne(String id);

    Event save(Event saved);
}
