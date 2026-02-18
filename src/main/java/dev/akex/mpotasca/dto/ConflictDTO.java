package dev.akex.mpotasca.dto;


import dev.akex.mpotasca.Status;
import dev.akex.mpotasca.entities.Country;

import java.time.LocalDate;
import java.util.Set;

public class ConflictDTO {
    private String name;
    private LocalDate startDate;
    private Status status;
    private String description;
    private Set<Country> countries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
