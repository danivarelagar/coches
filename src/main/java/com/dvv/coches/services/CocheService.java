package com.dvv.coches.services;

import com.dvv.coches.models.Coche;
import com.dvv.coches.repository.CocheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public Coche save(Coche coche) {
        return cocheRepository.save(coche);
    }

    public List<Coche> findAll() {
        return cocheRepository.findAll();
    }

    public Optional<Coche> findById(Long id) {
        return cocheRepository.findById(id);
    }

    public List<Coche> findAvailableCars() {
        return cocheRepository.findByAvailableTrue();
    }

    public void delete(Long id) {
        cocheRepository.deleteById(id);
    }
}
