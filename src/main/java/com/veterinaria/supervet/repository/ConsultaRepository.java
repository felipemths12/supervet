package com.veterinaria.supervet.repository;

import com.veterinaria.supervet.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository <Consulta, Long> {
}
