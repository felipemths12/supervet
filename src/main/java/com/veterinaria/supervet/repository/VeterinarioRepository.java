package com.veterinaria.supervet.repository;

import com.veterinaria.supervet.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository <Veterinario, Long> {
}
