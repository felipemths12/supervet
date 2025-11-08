package com.veterinaria.supervet.dto.tutor;

import com.veterinaria.supervet.model.Tutor;

public record DadosTutorResumido(
        Long id,
        String nome,
        String telefone
) {
    public DadosTutorResumido(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone());
    }
}
