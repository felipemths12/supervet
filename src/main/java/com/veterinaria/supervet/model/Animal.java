package com.veterinaria.supervet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "animais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Integer getIdade() {
        if (this.dataNascimento == null) {
            return null;
        }

        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }
}
