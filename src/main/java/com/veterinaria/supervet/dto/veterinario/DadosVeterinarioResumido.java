package com.veterinaria.supervet.dto.veterinario;

import com.veterinaria.supervet.model.Veterinario;

public record DadosVeterinarioResumido(
        Long id,
        String nome
) {
    public DadosVeterinarioResumido (Veterinario vet) {
        this(vet.getId(), vet.getNome());
    }
}
