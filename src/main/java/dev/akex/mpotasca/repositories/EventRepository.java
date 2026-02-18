package dev.akex.mpotasca.repositories;

import dev.akex.mpotasca.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Iterable<Event> getAllByLocationIs(String location);

    Event findEventById(long id);

    void deleteEventById(long id);
}
