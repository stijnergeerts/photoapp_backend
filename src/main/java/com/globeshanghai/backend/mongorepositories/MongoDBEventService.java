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

/**
 * Created by stijnergeerts on 19/04/17.
 */

@Service
 final class MongoDBEventService implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    MongoDBEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

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
                .build();
        eventRepository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public EventDTO delete(String id) {
        Event event = findEventById(id);
        eventRepository.delete(event);
        return convertToDTO(event);
    }

    @Override
    public List<EventDTO> findAll() {
        List<Event> configurationEntries = eventRepository.findAll();
        return convertToDTOs(configurationEntries);
    }

    @Override
    public EventDTO findById(String id) {
        Event found = findEventById(id);
        return convertToDTO(found);
    }

    @Override
    public EventDTO update(EventDTO event) {
        Event updated = findEventById(event.getEventId());
        updated.update(event.getEventName(),event.getEventLogo(),event.getEventStartDate(),event.getEventEndDate(),event.getEventLocation(),
                event.getEventAddress(), event.getCompany(),event.getCompanyAddress(),event.getContact(),event.getContactPhone(),
                event.getConfig(),event.getDetailLayout(),event.getOverviewLayout());
        updated = eventRepository.save(updated);
        return convertToDTO(updated);
    }


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
        return dto;
    }
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
