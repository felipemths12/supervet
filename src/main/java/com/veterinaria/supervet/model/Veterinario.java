package com.veterinaria.supervet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crmv;
    private String especialidade;
}
