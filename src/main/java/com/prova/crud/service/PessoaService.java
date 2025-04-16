package com.prova.crud.service;

import com.prova.crud.dto.PessoaDTO;
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
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public PessoaDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        if (pessoaDTO.getTrabalhoId() != null) {
            Optional<Trabalho> trabalho = trabalhoRepository.findById(pessoaDTO.getTrabalhoId());
            trabalho.ifPresent(pessoa::setTrabalho);
        }
        pessoa = pessoaRepository.save(pessoa);
        pessoaDTO.setId(pessoa.getId());
        return pessoaDTO;
    }

    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            pessoa.setCpf(pessoaDTO.getCpf());
            pessoa.setIdade(pessoaDTO.getIdade());
            if (pessoaDTO.getTrabalhoId() != null) {
                Optional<Trabalho> trabalho = trabalhoRepository.findById(pessoaDTO.getTrabalhoId());
                trabalho.ifPresent(pessoa::setTrabalho);
            }
            pessoa = pessoaRepository.save(pessoa);
            return pessoaDTO;
        }
        return null;
    }

    public PessoaDTO findById(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setId(pessoa.getId());
            pessoaDTO.setCpf(pessoa.getCpf());
            pessoaDTO.setIdade(pessoa.getIdade());
            if (pessoa.getTrabalho() != null) {
                pessoaDTO.setTrabalhoId(pessoa.getTrabalho().getId());
            }
            return pessoaDTO;
        }
        return null;
    }

    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll().stream().map(pessoa -> {
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setId(pessoa.getId());
            pessoaDTO.setCpf(pessoa.getCpf());
            pessoaDTO.setIdade(pessoa.getIdade());
            if (pessoa.getTrabalho() != null) {
                pessoaDTO.setTrabalhoId(pessoa.getTrabalho().getId());
            }
            return pessoaDTO;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}