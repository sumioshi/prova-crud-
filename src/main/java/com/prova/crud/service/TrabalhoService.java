package com.prova.crud.service;

import com.prova.crud.dto.TrabalhoDTO;
import com.prova.crud.model.Pessoa;
import com.prova.crud.model.Trabalho;
import com.prova.crud.repository.PessoaRepository;
import com.prova.crud.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public TrabalhoDTO create(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = new Trabalho();
        trabalho.setNome(trabalhoDTO.getNome());
        trabalho.setEndereco(trabalhoDTO.getEndereco());
        trabalho = trabalhoRepository.save(trabalho);
        trabalhoDTO.setId(trabalho.getId());
        return trabalhoDTO;
    }

    public TrabalhoDTO update(Long id, TrabalhoDTO trabalhoDTO) {
        Optional<Trabalho> optionalTrabalho = trabalhoRepository.findById(id);
        if (optionalTrabalho.isPresent()) {
            Trabalho trabalho = optionalTrabalho.get();
            trabalho.setNome(trabalhoDTO.getNome());
            trabalho.setEndereco(trabalhoDTO.getEndereco());
            trabalho = trabalhoRepository.save(trabalho);
            return trabalhoDTO;
        }
        return null;
    }

    public TrabalhoDTO findById(Long id) {
        Optional<Trabalho> optionalTrabalho = trabalhoRepository.findById(id);
        if (optionalTrabalho.isPresent()) {
            Trabalho trabalho = optionalTrabalho.get();
            TrabalhoDTO trabalhoDTO = new TrabalhoDTO();
            trabalhoDTO.setId(trabalho.getId());
            trabalhoDTO.setNome(trabalho.getNome());
            trabalhoDTO.setEndereco(trabalho.getEndereco());
            List<Long> pessoaIds = trabalho.getPessoas().stream()
                    .map(Pessoa::getId)
                    .collect(Collectors.toList());
            trabalhoDTO.setPessoaIds(pessoaIds);
            return trabalhoDTO;
        }
        return null;
    }

    public List<TrabalhoDTO> findAll() {
        return trabalhoRepository.findAll().stream().map(trabalho -> {
            TrabalhoDTO trabalhoDTO = new TrabalhoDTO();
            trabalhoDTO.setId(trabalho.getId());
            trabalhoDTO.setNome(trabalho.getNome());
            trabalhoDTO.setEndereco(trabalho.getEndereco());
            List<Long> pessoaIds = trabalho.getPessoas().stream()
                    .map(Pessoa::getId)
                    .collect(Collectors.toList());
            trabalhoDTO.setPessoaIds(pessoaIds);
            return trabalhoDTO;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        trabalhoRepository.deleteById(id);
    }
}