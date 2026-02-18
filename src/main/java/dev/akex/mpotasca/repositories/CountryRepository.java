package dev.akex.mpotasca.repositories;

import dev.akex.mpotasca.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    Country findCountryById(long id);

    void deleteCountryById(long id);

    Country getCountryByCode(String code);

    Iterable<Country> getAllByNameIs(String name);
}
