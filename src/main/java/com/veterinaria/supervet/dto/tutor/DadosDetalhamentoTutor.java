package com.veterinaria.supervet.dto.tutor;

import com.veterinaria.supervet.model.Tutor;

public record DadosDetalhamentoTutor(
        Long id,
        String nome,
        String email,
        String telefone
) {
    public DadosDetalhamentoTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone());
    }
}
