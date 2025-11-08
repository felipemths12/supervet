package com.veterinaria.supervet.dto.veterinario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVeterinario(
        @NotBlank
        String nome,

        @NotBlank
        String crmv,

        @NotBlank
        String especialidade
) {
}
