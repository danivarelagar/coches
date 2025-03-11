package com.dvv.coches.repository;

import com.dvv.coches.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CocheRepository extends JpaRepository<Coche, Long> {
    List<Coche> findByBrandContainingIgnoreCaseAndModelContainingIgnoreCase(String brand, String model);
    List<Coche> findByAvailableTrue();
}

