package com.prova.crud.controller;

import com.prova.crud.dto.TrabalhoDTO;
import com.prova.crud.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public ResponseEntity<TrabalhoDTO> create(@RequestBody TrabalhoDTO trabalhoDTO) {
        TrabalhoDTO createdTrabalho = trabalhoService.create(trabalhoDTO);
        return new ResponseEntity<>(createdTrabalho, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> update(@PathVariable Long id, @RequestBody TrabalhoDTO trabalhoDTO) {
        TrabalhoDTO updatedTrabalho = trabalhoService.update(id, trabalhoDTO);
        if (updatedTrabalho != null) {
            return new ResponseEntity<>(updatedTrabalho, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> findById(@PathVariable Long id) {
        TrabalhoDTO trabalhoDTO = trabalhoService.findById(id);
        if (trabalhoDTO != null) {
            return new ResponseEntity<>(trabalhoDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TrabalhoDTO>> findAll() {
        List<TrabalhoDTO> trabalhos = trabalhoService.findAll();
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trabalhoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}