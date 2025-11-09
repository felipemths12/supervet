package com.veterinaria.supervet.service;

import com.veterinaria.supervet.dto.veterinario.DadosAtualizacaoVeterinario;
import com.veterinaria.supervet.dto.veterinario.DadosCadastroVeterinario;
import com.veterinaria.supervet.dto.veterinario.DadosDetalhamentoVeterinario;
import com.veterinaria.supervet.model.Veterinario;
import com.veterinaria.supervet.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Transactional
    public DadosDetalhamentoVeterinario salvarVeterinario(DadosCadastroVeterinario dto) {
        Veterinario vet = new Veterinario();
        vet.setNome(dto.nome());
        vet.setCrmv(dto.crmv());
        vet.setEspecialidade(dto.especialidade());

        Veterinario vetSalvo = veterinarioRepository.save(vet);
        return new DadosDetalhamentoVeterinario(vetSalvo);
    }

    @Transactional(readOnly = true)
    public List<DadosDetalhamentoVeterinario> listarTodosVeterinarios() {
        return veterinarioRepository.findAll().stream()
                .map(DadosDetalhamentoVeterinario::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoVeterinario buscarVeterinarioPorId(Long id) {
        Veterinario vet = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        return new DadosDetalhamentoVeterinario(vet);
    }

    @Transactional
    public DadosDetalhamentoVeterinario atualizaarVeterinario(Long id, DadosAtualizacaoVeterinario dto) {
        Veterinario vet = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        if(dto.nome() != null) {
            vet.setNome(dto.nome());
        }

        if(dto.especialidade() != null) {
            vet.setEspecialidade(dto.especialidade());
        }

        Veterinario vetAtualizado = veterinarioRepository.save(vet);
        return new DadosDetalhamentoVeterinario((vetAtualizado));
    }

    @Transactional
    public void deletarVeterinario(Long id) {
        if(!veterinarioRepository.existsById(id)) {
            throw new RuntimeException("Veterinário não encontrado");
        }

        veterinarioRepository.deleteById(id);
    }
}
