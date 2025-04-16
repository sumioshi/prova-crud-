package com.prova.crud.controller;

import com.prova.crud.dto.PessoaDTO;
import com.prova.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO createdPessoa = pessoaService.create(pessoaDTO);
        return new ResponseEntity<>(createdPessoa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO updatedPessoa = pessoaService.update(id, pessoaDTO);
        if (updatedPessoa != null) {
            return new ResponseEntity<>(updatedPessoa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        if (pessoaDTO != null) {
            return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> pessoas = pessoaService.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}