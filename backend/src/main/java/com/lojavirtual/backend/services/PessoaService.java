package com.lojavirtual.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lojavirtual.backend.entities.Pessoa;
import com.lojavirtual.backend.exceptions.ResourceNotFoundException;
import com.lojavirtual.backend.repositories.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
     PessoaRepository pessoaRepository;


     public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
     }

     public Pessoa salvarPessoa(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public Pessoa alterarPessoa(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        Pessoa pessoaAlterada = pessoaRepository.saveAndFlush(pessoa);
        return pessoaAlterada;
    }

    public void excluirPessoa(Long pessoaId){
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada! Id = " + pessoaId));

        pessoaRepository.delete(pessoa);
    }

}
