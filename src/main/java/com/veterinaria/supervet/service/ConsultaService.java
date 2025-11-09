package com.veterinaria.supervet.service;

import com.veterinaria.supervet.dto.consulta.DadosAgendamentoConsulta;
import com.veterinaria.supervet.dto.consulta.DadosDetalhamentoConsulta;
import com.veterinaria.supervet.model.Animal;
import com.veterinaria.supervet.model.Consulta;
import com.veterinaria.supervet.model.Veterinario;
import com.veterinaria.supervet.repository.AnimalRepository;
import com.veterinaria.supervet.repository.ConsultaRepository;
import com.veterinaria.supervet.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Transactional
    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dto) {
        Animal animal = animalRepository.findById(dto.animalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        Veterinario veterinario = veterinarioRepository.findById(dto.veterinarioId())
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setAnimal(animal);
        consulta.setVeterinario(veterinario);
        consulta.setDataHora(dto.dataHora());
        consulta.setMotivo(dto.motivo());

        Consulta consultaSalva = consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consultaSalva);
    }

    @Transactional(readOnly = true)
    public List<DadosDetalhamentoConsulta> listarTodasConsultas() {
        return consultaRepository.findAll().stream()
                .map(DadosDetalhamentoConsulta::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelarConsulta(Long id) {
        if(!consultaRepository.existsById(id)) {
            throw new RuntimeException("Consulta não encontrada");
        }

        consultaRepository.deleteById(id);
    }
}
