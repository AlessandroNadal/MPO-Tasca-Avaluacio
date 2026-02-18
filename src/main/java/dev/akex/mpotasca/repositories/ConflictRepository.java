package dev.akex.mpotasca.repositories;

import dev.akex.mpotasca.Status;
import dev.akex.mpotasca.entities.Conflict;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConflictRepository extends CrudRepository<Conflict, Integer> {
    String getAllByIdNotNull(long id);

    Conflict findConflictById(long id);

    void deleteConflictById(long id);

    Iterable<Conflict> getAllByStatusIs(Status status);

}
