package dev.akex.mpotasca.dto;


import dev.akex.mpotasca.entities.Conflict;
import dev.akex.mpotasca.entities.Country;

import java.util.Set;

public class FactionDTO {
    private String name;
    private Conflict conflict;
    private Set<Country> countries;

    public Conflict getConflict() {
        return conflict;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}