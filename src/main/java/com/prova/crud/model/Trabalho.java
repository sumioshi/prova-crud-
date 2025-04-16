package com.prova.crud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String endereco;

    @OneToMany(mappedBy = "trabalho")
    private List<Pessoa> pessoas;
}