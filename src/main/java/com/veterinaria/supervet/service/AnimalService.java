package com.veterinaria.supervet.service;

import com.veterinaria.supervet.model.Animal;
import com.veterinaria.supervet.model.Tutor;
import com.veterinaria.supervet.repository.AnimalRepository;
import com.veterinaria.supervet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TutorRepository tutorRepository;


    public List<Animal> listarTodosAnimais() {
        return animalRepository.findAll();
    }

    public Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal salvarAnimal(Animal animal) {
        if (animal.getTutor() != null && animal.getTutor().getId() != null) {
            Long tutorId = animal.getTutor().getId();

            Tutor tutor = tutorRepository.findById(tutorId)
                    .orElseThrow(() -> new RuntimeException("Tutor não encontrado com o ID: " + tutorId));

            animal.setTutor(tutor);
        } else {
            throw new RuntimeException("O animal precisa de um tutor válido.");
        }

        return animalRepository.save(animal);
    }

    public void deletarAnimal(Long id) {
        Animal animalParaDeletar = buscarAnimalPorId(id);
        animalRepository.delete(animalParaDeletar);
    }
}
