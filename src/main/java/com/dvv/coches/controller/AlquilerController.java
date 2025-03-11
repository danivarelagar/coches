package com.dvv.coches.controller;



import com.dvv.coches.models.Alquiler;
import com.dvv.coches.services.AlquilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping
    public Alquiler rentCar(@RequestBody Alquiler alquiler) {
        return alquilerService.rentCar(alquiler);
    }

    @GetMapping
    public List<Alquiler> getAllRentals() {
        return alquilerService.getAllRentals();
    }

    @GetMapping("/usuario/{id}")
    public List<Alquiler> getRentalsByUser(@PathVariable Long id) {
        return alquilerService.getRentalsByUser(id);
    }

    @PutMapping("/{id}/return")
    public void returnCar(@PathVariable Long id) {
        alquilerService.returnCar(id);
    }
}

