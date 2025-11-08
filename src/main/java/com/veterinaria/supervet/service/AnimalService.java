package com.veterinaria.supervet.service;

import com.veterinaria.supervet.dto.DadosAtualizacaoAnimal;
import com.veterinaria.supervet.dto.DadosCadastroAnimal;
import com.veterinaria.supervet.dto.DadosDetalhamentoAnimal;
import com.veterinaria.supervet.model.Animal;
import com.veterinaria.supervet.model.Tutor;
import com.veterinaria.supervet.repository.AnimalRepository;
import com.veterinaria.supervet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private TutorRepository tutorRepository;

    @Transactional(readOnly = true)
    public List<DadosDetalhamentoAnimal> listarTodos() {
        List<Animal> animais = animalRepository.findAll();
        return animais.stream()
                .map(DadosDetalhamentoAnimal::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoAnimal buscarPorId(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com id: " + id));
        return new DadosDetalhamentoAnimal(animal);
    }

    @Transactional
    public DadosDetalhamentoAnimal salvarAnimal(DadosCadastroAnimal dto) {
        Tutor tutor = tutorRepository.findById(dto.tutorId())
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com esse ID: " + dto.tutorId()));

        Animal animal = new Animal();
        animal.setNome(dto.nome());
        animal.setEspecie(dto.especie());
        animal.setRaca(dto.raca());
        animal.setDataNascimento(dto.dataNascimento());
        animal.setTutor(tutor);

        Animal animalSalvo = animalRepository.save(animal);

        return new DadosDetalhamentoAnimal(animalSalvo);
    }

    @Transactional
    public DadosDetalhamentoAnimal atualizarAnimal(Long id, DadosAtualizacaoAnimal dto) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com esse ID: " + id));

        if(dto.nome() != null && !dto.nome().isBlank()) {
            animal.setNome(dto.nome());
        }

        if (dto.especie() != null && !dto.especie().isBlank()) {
            animal.setEspecie(dto.especie());
        }

        if (dto.raca() != null) {
            animal.setRaca(dto.raca());
        }

        if (dto.dataNascimento() != null) {
            animal.setDataNascimento(dto.dataNascimento());
        }

        Animal animalAtualizado = animalRepository.save(animal);

        return new DadosDetalhamentoAnimal(animalAtualizado);
    }

    @Transactional
    public void deletarAnimal(Long id) {
        Animal animalParaDeletar = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com esse ID: " + id));

        animalRepository.delete(animalParaDeletar);
    }
}
