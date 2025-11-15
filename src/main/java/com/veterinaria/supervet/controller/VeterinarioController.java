package com.veterinaria.supervet.controller;

import com.veterinaria.supervet.dto.veterinario.DadosAtualizacaoVeterinario;
import com.veterinaria.supervet.dto.veterinario.DadosCadastroVeterinario;
import com.veterinaria.supervet.dto.veterinario.DadosDetalhamentoVeterinario;
import com.veterinaria.supervet.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoVeterinario> cadastrarVeterinario(@RequestBody
                                                                                 @Valid DadosCadastroVeterinario dto) {
        DadosDetalhamentoVeterinario vetSalvo = veterinarioService.salvarVeterinario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(vetSalvo);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoVeterinario>> listarTodosVeterinarios() {

        return ResponseEntity.ok((veterinarioService.listarTodosVeterinarios()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoVeterinario> buscarVeterinarioPorId(@PathVariable Long id) {

        return ResponseEntity.ok(veterinarioService.buscarVeterinarioPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoVeterinario> atualizarVeterinario (@PathVariable Long id,
                                                                              @RequestBody @Valid DadosAtualizacaoVeterinario dto) {

        return ResponseEntity.ok(veterinarioService.atualizaarVeterinario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoVeterinario> deletarVeterinario(@PathVariable Long id) {

        veterinarioService.deletarVeterinario(id);

        return ResponseEntity.noContent().build();
    }
}
