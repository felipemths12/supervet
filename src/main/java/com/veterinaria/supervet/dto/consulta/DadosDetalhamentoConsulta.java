package com.veterinaria.supervet.dto.consulta;

import com.veterinaria.supervet.dto.animal.DadosAnimalResumido;
import com.veterinaria.supervet.dto.veterinario.DadosDetalhamentoVeterinario;
import com.veterinaria.supervet.dto.veterinario.DadosVeterinarioResumido;
import com.veterinaria.supervet.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,
        LocalDateTime dataHora,
        String motivo,
        String diagnostico,
        DadosAnimalResumido animal,
        DadosVeterinarioResumido veterinario
) {
    public DadosDetalhamentoConsulta (Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getMotivo(),
                consulta.getDiagnostico(),
                new DadosAnimalResumido(consulta.getAnimal()),
                new DadosVeterinarioResumido(consulta.getVeterinario())
        );
    }
 }
