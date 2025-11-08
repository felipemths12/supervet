package com.veterinaria.supervet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroAnimal(
        @NotBlank
        String nome,

        @NotBlank
        String especie,

        String raca,

        @NotNull
        LocalDate dataNascimento,

        @NotNull
        Long tutorId
) {}
