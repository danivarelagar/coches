package com.dvv.coches.controller;


import com.dvv.coches.models.Coche;
import com.dvv.coches.services.CocheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coches")
public class CocheController {

    private final CocheService cocheService;

    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @PostMapping
    public Coche create(@RequestBody Coche coche) {
        return cocheService.save(coche);
    }

    @GetMapping
    public List<Coche> getAll() {
        return cocheService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coche> getById(@PathVariable Long id) {
        return cocheService.findById(id);
    }

    @GetMapping("/available")
    public List<Coche> getAvailableCars() {
        return cocheService.findAvailableCars();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cocheService.delete(id);
    }
}
