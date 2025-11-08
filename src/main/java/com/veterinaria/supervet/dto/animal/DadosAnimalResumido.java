package com.veterinaria.supervet.dto.animal;

import com.veterinaria.supervet.model.Animal;

public record DadosAnimalResumido(
        Long id,
        String nome
) {
    public DadosAnimalResumido (Animal animal) {
        this(animal.getId(), animal.getNome()
        );
    }
}
