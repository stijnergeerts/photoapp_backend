package com.globeshanghai.backend.mongorepositories;

import com.globeshanghai.backend.dom.event.Event;
import com.globeshanghai.backend.dto.EventDTO;
import com.globeshanghai.backend.exceptions.EventNotFoundException;
import com.globeshanghai.backend.repositories.EventRepository;
import com.globeshanghai.backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
 public class MongoDBEventService implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    MongoDBEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Save a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param event EventDTO
     * @return EventDTO
     */
    @Override
    public EventDTO create(EventDTO event) {
        Event persisted =  Event.getBuilder()
                .eventName(event.getEventName())
                .eventLogo(event.getEventLogo())
                .eventStartDate(event.getEventStartDate())
                .eventEndDate(event.getEventEndDate())
                .eventLocation(event.getEventLocation())
                .eventAddress(event.getEventAddress())
                .company(event.getCompany())
                .companyAddress(event.getCompanyAddress())
                .contact(event.getContact())
                .contactPhone(event.getContactPhone())
                .config(event.getConfig())
                .detailLayout(event.getDetailLayout())
                .overviewLayout(event.getOverviewLayout())
                .eventText(event.getEventText())
                .build();
        eventRepository.save(persisted);
        return convertToDTO(persisted);
    }

    /**
     * Delete a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param id Event eventId
     * @return EventDTO
     */
    @Override
    public EventDTO delete(String id) {
        Event event = findEventById(id);
        eventRepository.delete(event);
        return convertToDTO(event);
    }

    /**
     * Delete a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param eventName Event eventName
     * @return EventDTO
     */
    @Override
    public EventDTO deleteByEventName(String eventName) {
        EventDTO eventDTO = findByEventName(eventName);
        Event event = convertToObject(eventDTO);
        eventRepository.delete(event);
        return convertToDTO(event);
    }

    /**
     * Find all {@link com.globeshanghai.backend.dom.event.Event}.
     * @return List of EventDTO
     */
    @Override
    public List<EventDTO> findAll() {
        List<Event> configurationEntries = eventRepository.findAll();
        return convertToDTOs(configurationEntries);
    }

    /**
     * Find a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param id Event eventId
     * @return EventDTO
     */
    @Override
    public EventDTO findById(String id) {
        Event found = findEventById(id);
        return convertToDTO(found);
    }

    /**
     * Find a {@link com.globeshanghai.backend.dom.event.Event}.
     * @param eventName Event eventName
     * @return EventDTO
     */
    @Override
    public EventDTO findByEventName(String eventName) {
        Event event = this.eventRepository.findEventByEventName(String.valueOf(eventName));
        if (event!=null)
            return convertToDTO(event);
        return null;
    }

    /**
     * Update an existing {@link com.globeshanghai.backend.dom.event.Event}.
     * @param event Event
     * @return EventDTO
     */
    @Override
    public EventDTO update(EventDTO event) {
        Event updated = findEventById(event.getEventId());
        updated.update(event.getEventName(),event.getEventLogo(),event.getEventStartDate(),event.getEventEndDate(),event.getEventLocation(),
                event.getEventAddress(), event.getCompany(),event.getCompanyAddress(),event.getContact(),event.getContactPhone(),
                event.getConfig(),event.getDetailLayout(),event.getOverviewLayout(),event.getEventText());
        updated = eventRepository.save(updated);
        return convertToDTO(updated);
    }

    /**
     * Convert a {@link com.globeshanghai.backend.dom.event.Event} to a {@link com.globeshanghai.backend.dto.EventDTO}
     * @param model Event
     * @return EventDTO
     */
    private EventDTO convertToDTO(Event model) {
        EventDTO dto = new EventDTO();
        dto.setEventId(model.getEventId());
        dto.setEventName(model.getEventName());
        dto.setEventLogo(model.getEventLogo());
        dto.setEventStartDate(model.getEventStartDate());
        dto.setEventEndDate(model.getEventEndDate());
        dto.setEventLocation(model.getEventLocation());
        dto.setEventAddress(model.getEventAddress());
        dto.setCompany(model.getCompany());
        dto.setCompanyAddress(model.getCompanyAddress());
        dto.setContact(model.getContact());
        dto.setContactPhone(model.getContactPhone());
        dto.setConfig(model.getConfig());
        dto.setDetailLayout(model.getDetailLayout());
        dto.setOverviewLayout(model.getOverviewLayout());
        dto.setEventText(model.getEventText());
        return dto;
    }

    /**
     * Convert a {@link com.globeshanghai.backend.dto.EventDTO} to a {@link com.globeshanghai.backend.dom.event.Event}
     * @param model EventDTO
     * @return EventDTO
     */
    private Event convertToObject(EventDTO model) {
        Event event = new Event();
        event.setEventId(model.getEventId());
        event.setEventName(model.getEventName());
        event.setEventLogo(model.getEventLogo());
        event.setEventStartDate(model.getEventStartDate());
        event.setEventEndDate(model.getEventEndDate());
        event.setEventLocation(model.getEventLocation());
        event.setEventAddress(model.getEventAddress());
        event.setCompany(model.getCompany());
        event.setCompanyAddress(model.getCompanyAddress());
        event.setContact(model.getContact());
        event.setContactPhone(model.getContactPhone());
        event.setConfig(model.getConfig());
        event.setDetailLayout(model.getDetailLayout());
        event.setOverviewLayout(model.getOverviewLayout());
        event.setEventText(model.getEventText());
        return event;
    }

    /**
     * Convert a list of {@link com.globeshanghai.backend.dom.event.Event} to a list of {@link com.globeshanghai.backend.dto.EventDTO}
     * @param models List of Event
     * @return EventDTO
     */
    private List<EventDTO> convertToDTOs(List<Event> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Event findEventById(String id) {
        Optional<Event> result = eventRepository.findOne(id);
        return result.orElseThrow(() -> new EventNotFoundException(id));
    }


}
