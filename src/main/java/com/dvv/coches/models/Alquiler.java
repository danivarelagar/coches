package com.dvv.coches.models;


import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Coche coche;

    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler status;

    // Campos personalizados
    private String daniel_seguro;
    private String daniel_kilometraje;

    public enum EstadoAlquiler {
        ACTIVE, COMPLETED
    }
}

