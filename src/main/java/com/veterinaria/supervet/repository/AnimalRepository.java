package com.veterinaria.supervet.repository;

import com.veterinaria.supervet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <Animal, Long>  {
}
