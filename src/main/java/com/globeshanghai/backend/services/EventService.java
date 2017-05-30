package com.globeshanghai.backend.services;

import com.globeshanghai.backend.dto.EventDTO;

import java.util.List;

/**
 * Created by stijnergeerts on 20/04/17.
 */
public interface EventService {

    EventDTO create(EventDTO event);

    EventDTO delete(String id);

    EventDTO deleteByEventName(String eventName);

    List<EventDTO> findAll();

    EventDTO findById(String id);

    EventDTO findByEventName(String eventName);

    EventDTO update(EventDTO event);
}
