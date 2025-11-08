package com.veterinaria.supervet.dto.animal;

import com.veterinaria.supervet.dto.tutor.DadosTutorResumido;
import com.veterinaria.supervet.model.Animal;

import java.time.LocalDate;

public record DadosDetalhamentoAnimal(
        Long id,
        String nome,
        String especie,
        String raca,
        LocalDate dataNascimento,
        Integer idade,
        DadosTutorResumido tutor
) {
    public DadosDetalhamentoAnimal (Animal animal) {
        this(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getRaca(),
                animal.getDataNascimento(),
                animal.getIdade(),
                new DadosTutorResumido(animal.getTutor())
        );
    }
}
