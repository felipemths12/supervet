package com.veterinaria.supervet.dto.tutor;

import jakarta.validation.constraints.Email;

public record DadosAtualizacaoTutor(
        String nome,

        @Email
        String email,

        String telefone
) {}
