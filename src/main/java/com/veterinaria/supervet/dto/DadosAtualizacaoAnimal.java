package com.veterinaria.supervet.dto;

import java.time.LocalDate;

public record DadosAtualizacaoAnimal(
        String nome,
        String especie,
        String raca,
        LocalDate dataNascimento
) { }
