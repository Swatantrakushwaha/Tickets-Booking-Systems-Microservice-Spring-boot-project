package com.microservice.InventoryService.Service;

import com.microservice.InventoryService.Entity.Event;
import com.microservice.InventoryService.Repository.EventRepository;
import com.microservice.InventoryService.Repository.VenueRepository;
import com.microservice.InventoryService.Response.EventInventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public InventoryService(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }


    public List<EventInventoryResponse> getAllEvents() {

        List<Event> event = eventRepository.findAll();
        return event.stream().map(event1 -> )




    }
}
