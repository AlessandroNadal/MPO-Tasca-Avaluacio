package dev.akex.mpotasca.controllers;

import dev.akex.mpotasca.entities.Conflict;
import dev.akex.mpotasca.repositories.ConflictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conflicts")
public class ConflictsController extends MainController {
    @Autowired
    private ConflictRepository conflictRepository;

    @GetMapping
    public String test() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public Conflict getConflict(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createConflict(@RequestBody Conflict conflict) {
        Conflict c = new Conflict();
        c.setName(conflict.getName());
        c.setStartDate(conflict.getStartDate());
        c.setStatus(conflict.getStatus());
        c.setDescription(conflict.getDescription());
        c.setCountries(conflict.getCountries());

        conflictRepository.save(c);
    }

    @PutMapping("/{id}")
    public void updateConflict(@RequestBody Conflict conflict) {

    }

    @DeleteMapping("/{id}")
    public void deleteConflict(@RequestBody Conflict conflict) {

    }
}
