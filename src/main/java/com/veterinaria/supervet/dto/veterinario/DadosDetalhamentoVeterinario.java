package com.veterinaria.supervet.dto.veterinario;

import com.veterinaria.supervet.model.Veterinario;

public record DadosDetalhamentoVeterinario(
        Long id,
        String nome,
        String crmv,
        String especialidade
) {
    public DadosDetalhamentoVeterinario(Veterinario vet) {
        this(vet.getId(), vet.getNome(), vet.getCrmv(), vet.getEspecialidade());
    }
}
