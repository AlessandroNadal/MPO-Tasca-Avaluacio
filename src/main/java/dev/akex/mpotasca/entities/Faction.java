package dev.akex.mpotasca.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faction")
public class Faction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "conflict")
    private Conflict conflict;

    @ManyToMany
    @JoinTable(
            name = "supports",
            joinColumns = @JoinColumn(name = "faction"),
            inverseJoinColumns = @JoinColumn(name = "conflict")
    )
    private Set<Country> countries = new HashSet<>();
}
