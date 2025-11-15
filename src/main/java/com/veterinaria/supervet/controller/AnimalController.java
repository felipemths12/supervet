package com.veterinaria.supervet.controller;

import com.veterinaria.supervet.dto.animal.DadosAtualizacaoAnimal;
import com.veterinaria.supervet.dto.animal.DadosCadastroAnimal;
import com.veterinaria.supervet.dto.animal.DadosDetalhamentoAnimal;
import com.veterinaria.supervet.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoAnimal> cadastrarAnimal (@RequestBody @Valid DadosCadastroAnimal dto) {

        DadosDetalhamentoAnimal animalSalvo = animalService.salvarAnimal(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(animalSalvo);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoAnimal>> listarAnimais() {
        List<DadosDetalhamentoAnimal> lista = animalService.listarTodosAnimais();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAnimal> listarAnimalPorId(@PathVariable Long id) {
        DadosDetalhamentoAnimal animal = animalService.buscarAnimaisPorId(id);

        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAnimal> atualizarAnimal(@PathVariable Long id,
                                                                   @RequestBody @Valid DadosAtualizacaoAnimal dto) {
        DadosDetalhamentoAnimal animalAtualizado = animalService.atualizarAnimal(id, dto);

        return ResponseEntity.ok(animalAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);

        return ResponseEntity.noContent().build();
    }
}
