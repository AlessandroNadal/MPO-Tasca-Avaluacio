package dev.akex.mpotasca.controllers;

import dev.akex.mpotasca.dto.EventDTO;
import dev.akex.mpotasca.entities.Event;
import dev.akex.mpotasca.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping
    public @ResponseBody Iterable<Event> findAll(@Nullable String location) {
        if (location == null)
            return eventRepository.findAll();

        return eventRepository.getAllByLocationIs(location);
    }

    @PostMapping
    public long createEvent(@RequestBody EventDTO eventDTO) {
        Event event = new Event();
        event.setEventDate(eventDTO.getEventDate());
        event.setConflict(eventDTO.getConflict());
        event.setLocation(eventDTO.getLocation());
        event.setDescription(eventDTO.getDescription());
        event = eventRepository.save(event);
        return event.getId();
    }

    @PutMapping("/{id}")
    public long updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        Event event = eventRepository.findEventById(id);
        event.setEventDate(eventDTO.getEventDate());
        event.setConflict(eventDTO.getConflict());
        event.setLocation(eventDTO.getLocation());
        event.setDescription(eventDTO.getDescription());
        event = eventRepository.save(event);
        return event.getId();
    }


    @GetMapping("/{id}")
    public @ResponseBody Event getConflict(@PathVariable Long id) {
        return eventRepository.findEventById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConflict(@RequestParam long id) {
        eventRepository.deleteEventById(id);
    }

}
