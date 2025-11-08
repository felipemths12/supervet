package com.veterinaria.supervet.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        @NotNull
        Long animalId,

        @NotNull
        Long veterinarioId,

        @NotNull
        @Future
        LocalDateTime dataHora,

        String motivo
        ) {
}
