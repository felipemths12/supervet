package com.veterinaria.supervet.controller;

import com.veterinaria.supervet.dto.consulta.DadosAgendamentoConsulta;
import com.veterinaria.supervet.dto.consulta.DadosDetalhamentoConsulta;
import com.veterinaria.supervet.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoConsulta> agendarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dto) {
        DadosDetalhamentoConsulta consultaAgendada = consultaService.agendar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaAgendada);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoConsulta>> listarTodasAsConsultas() {
        return ResponseEntity.ok(consultaService.listarTodasConsultas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);

        return ResponseEntity.noContent().build();
    }
}
