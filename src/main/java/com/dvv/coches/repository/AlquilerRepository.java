package com.dvv.coches.repository;


import com.dvv.coches.models.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findByUsuarioId(Long userId);
}


