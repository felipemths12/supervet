package com.veterinaria.supervet.controller;

import com.veterinaria.supervet.dto.tutor.DadosAtualizacaoTutor;
import com.veterinaria.supervet.dto.tutor.DadosCadastroTutor;
import com.veterinaria.supervet.dto.tutor.DadosDetalhamentoTutor;
import com.veterinaria.supervet.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTutor> cadastrarTutor(@RequestBody @Valid DadosCadastroTutor dto) {
        DadosDetalhamentoTutor tutorSalvo = tutorService.salvarTutor(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(tutorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTutor>> listarTodosTutores() {
        return ResponseEntity.ok(tutorService.listarTodosTutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTutor> listarTutorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tutorService.buscarTutorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTutor> atualizarTutor(@PathVariable Long id,
                                                                  @RequestBody @Valid DadosAtualizacaoTutor dto) {
        return ResponseEntity.ok(tutorService.atualizarTutor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Long id) {
        tutorService.deletarTutor(id);

        return ResponseEntity.noContent().build();
    }
}
