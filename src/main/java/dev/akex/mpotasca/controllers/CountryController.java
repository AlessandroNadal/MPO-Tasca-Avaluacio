package dev.akex.mpotasca.controllers;

import dev.akex.mpotasca.dto.CountryDTO;
import dev.akex.mpotasca.entities.Country;
import dev.akex.mpotasca.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping
    public @ResponseBody Iterable<Country> findAll(@Nullable String name) {
        if (name == null)
            return countryRepository.findAll();

        return countryRepository.getAllByNameIs(name);
    }

    @PostMapping
    public long createCountry(@RequestBody CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        country = countryRepository.save(country);

        return country.getId();
    }

    @PutMapping("/{id}")
    public long updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        Country country = countryRepository.findCountryById(id);
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        country = countryRepository.save(country);

        return country.getId();
    }


    @GetMapping("/{id}")
    public @ResponseBody Country getCountry(@PathVariable Long id) {
        return countryRepository.findCountryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@RequestParam long id) {
        countryRepository.deleteCountryById(id);
    }

}
