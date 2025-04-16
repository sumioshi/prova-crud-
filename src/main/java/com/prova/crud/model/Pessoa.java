package com.prova.crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpf;

    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
    private Trabalho trabalho;
}