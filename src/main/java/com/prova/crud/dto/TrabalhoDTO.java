package com.prova.crud.dto;

import lombok.Data;
import java.util.List;

@Data
public class TrabalhoDTO {
    private Long id;
    private String nome;
    private String endereco;
    private List<Long> pessoaIds;
}