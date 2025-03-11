package com.dvv.coches.services;



import com.dvv.coches.models.Alquiler;
import com.dvv.coches.models.Coche;
import com.dvv.coches.repository.AlquilerRepository;
import com.dvv.coches.repository.CocheRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService {

    private final AlquilerRepository alquilerRepository;
    private final CocheRepository cocheRepository;

    public AlquilerService(AlquilerRepository alquilerRepository, CocheRepository cocheRepository) {
        this.alquilerRepository = alquilerRepository;
        this.cocheRepository = cocheRepository;
    }

    public Alquiler rentCar(Alquiler alquiler) {
        Coche coche = alquiler.getCoche();

        if (!coche.getAvailable()) {
            throw new IllegalStateException("El coche ya está alquilado");
        }

        coche.setAvailable(false);
        cocheRepository.save(coche);
        alquiler.setRentalDate(LocalDateTime.now());
        alquiler.setStatus(Alquiler.EstadoAlquiler.ACTIVE);

        return alquilerRepository.save(alquiler);
    }

    public List<Alquiler> getAllRentals() {
        return alquilerRepository.findAll();
    }

    public List<Alquiler> getRentalsByUser(Long userId) {
        return alquilerRepository.findByUsuarioId(userId);
    }

    public void returnCar(Long id) {
        Optional<Alquiler> optionalRental = alquilerRepository.findById(id);

        if (optionalRental.isPresent()) {
            Alquiler alquiler = optionalRental.get();
            Coche coche = alquiler.getCoche();

            coche.setAvailable(true);
            cocheRepository.save(coche);

            alquiler.setReturnDate(LocalDateTime.now());
            alquiler.setStatus(Alquiler.EstadoAlquiler.COMPLETED);

            alquilerRepository.save(alquiler);
        } else {
            throw new IllegalStateException("No se encontró el alquiler");
        }
    }
}
