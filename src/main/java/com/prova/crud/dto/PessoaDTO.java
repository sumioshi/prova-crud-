package com.prova.crud.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String cpf;
    private Integer idade;
    private Long trabalhoId;
}