package dev.akex.mpotasca.repositories;

import dev.akex.mpotasca.entities.Faction;
import org.springframework.data.repository.CrudRepository;

public interface FactionRepository extends CrudRepository<Faction, Integer> {
    Iterable<Faction> getAllByNameIs(String name);

    Faction findFactionById(long id);

    void deleteFactionById(long id);
}
