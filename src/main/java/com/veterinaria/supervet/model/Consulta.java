package com.veterinaria.supervet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private String motivo;

    private String diagnostico;

    @ManyToOne
    @JoinColumn (name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn (name = "veterinario_id")
    private Veterinario veterinario;
}
