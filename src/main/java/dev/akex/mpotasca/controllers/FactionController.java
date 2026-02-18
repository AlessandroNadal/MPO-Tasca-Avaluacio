package dev.akex.mpotasca.controllers;

import dev.akex.mpotasca.dto.FactionDTO;
import dev.akex.mpotasca.entities.Faction;
import dev.akex.mpotasca.repositories.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;

@RestController
@RequestMapping("/api/v1/faction")
public class FactionController {
    @Autowired
    FactionRepository factionRepository;

    @GetMapping
    public @ResponseBody Iterable<Faction> findAll(@Nullable String name) {
        if (name == null)
            return factionRepository.findAll();

        return factionRepository.getAllByNameIs(name);
    }

    @PostMapping
    public long createFaction(@RequestBody FactionDTO factionDTO) {
        Faction faction = new Faction();
        faction.setName(factionDTO.getName());
        faction.setConflict(factionDTO.getConflict());
        faction.setCountries(factionDTO.getCountries());
        faction = factionRepository.save(faction);

        return faction.getId();
    }

    @PutMapping("/{id}")
    public long updateConflict(@PathVariable Long id, @RequestBody FactionDTO factionDTO) {
        Faction faction = factionRepository.findFactionById(id);
        faction.setName(factionDTO.getName());
        faction.setConflict(factionDTO.getConflict());
        faction.setCountries(factionDTO.getCountries());
        faction = factionRepository.save(faction);

        return faction.getId();
    }


    @GetMapping("/{id}")
    public @ResponseBody Faction getFaction(@PathVariable Long id) {
        return factionRepository.findFactionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFaction(@RequestParam long id) {
        factionRepository.deleteFactionById(id);
    }

}
