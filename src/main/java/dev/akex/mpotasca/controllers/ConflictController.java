package dev.akex.mpotasca.controllers;

import dev.akex.mpotasca.Status;
import dev.akex.mpotasca.dto.ConflictDTO;
import dev.akex.mpotasca.entities.Conflict;
import dev.akex.mpotasca.repositories.ConflictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {
    @Autowired
    ConflictRepository conflictRepository;

    @GetMapping
    public @ResponseBody Iterable<Conflict> findAll(@Nullable Status status) {
        if (status == null)
            return conflictRepository.findAll();

        return conflictRepository.getAllByStatusIs(status);
    }

    @PostMapping
    public long foo(@RequestBody ConflictDTO conflict) {
        Conflict c = new Conflict();
        c.setName(conflict.getName());
        c.setDescription(conflict.getDescription());
        c.setCountries(conflict.getCountries());
        c.setStatus(conflict.getStatus());
        c.setStartDate(conflict.getStartDate());
        c = conflictRepository.save(c);

        return c.getId();
    }


    @GetMapping("/{id}")
    public @ResponseBody Conflict getConflict(@PathVariable Long id) {
        return conflictRepository.findConflictById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConflict(@RequestParam long id) {
        conflictRepository.deleteConflictById(id);
    }
}
