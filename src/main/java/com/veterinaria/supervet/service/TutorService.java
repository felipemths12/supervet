package com.veterinaria.supervet.service;

import com.veterinaria.supervet.dto.tutor.DadosAtualizacaoTutor;
import com.veterinaria.supervet.dto.tutor.DadosCadastroTutor;
import com.veterinaria.supervet.dto.tutor.DadosDetalhamentoTutor;
import com.veterinaria.supervet.model.Tutor;
import com.veterinaria.supervet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TutorService {

    @Autowired
     private TutorRepository tutorRepository;

    @Transactional
    public DadosDetalhamentoTutor salvarTutor(DadosCadastroTutor dto) {
        Tutor tutor = new Tutor();
        tutor.setNome(dto.nome());
        tutor.setEmail(dto.email());
        tutor.setTelefone(dto.telefone());
        tutor.setCpf(dto.cpf());

        Tutor tutorSalvo = tutorRepository.save(tutor);

        return new DadosDetalhamentoTutor(tutorSalvo);
    }

    @Transactional(readOnly = true)
    public List<DadosDetalhamentoTutor> listarTodosTutores() {
        return tutorRepository.findAll().stream()
                .map(DadosDetalhamentoTutor::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoTutor buscarTutorPorId(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        return new DadosDetalhamentoTutor(tutor);
    }

    @Transactional
    public DadosDetalhamentoTutor atualizarTutor(Long id, DadosAtualizacaoTutor dto) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        if(dto.nome() != null) {
            tutor.setNome(dto.nome());
        }

        if(dto.email() != null) {
            tutor.setEmail(dto.email());
        }

        if(dto.telefone() != null) {
            tutor.setTelefone(dto.telefone());
        }

        Tutor tutorAtualizado = tutorRepository.save(tutor);

        return new DadosDetalhamentoTutor(tutorAtualizado);
    }

    @Transactional
    public void deletarTutor(Long id) {
        if(!tutorRepository.existsById(id)) {
            throw new RuntimeException("Tutor não encontrado");
        }

        tutorRepository.deleteById(id);
    }
}
