package com.veterinaria.supervet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "animais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private String raca;
    private String sexo;
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn (name = "tutor_id")
    private Tutor tutor;
}
