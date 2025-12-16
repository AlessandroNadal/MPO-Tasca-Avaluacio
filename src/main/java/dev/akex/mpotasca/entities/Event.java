package dev.akex.mpotasca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate eventDate;
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "conflict")
    private Conflict conflict;

}
