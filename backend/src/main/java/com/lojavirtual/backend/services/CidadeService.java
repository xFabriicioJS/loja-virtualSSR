package com.lojavirtual.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.entities.Cidade;
import com.lojavirtual.backend.exceptions.ResourceNotFoundException;
import com.lojavirtual.backend.repositories.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository cidadeRepository;


    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade salvarCidade(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepository.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade alterarCidade(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        Cidade cidadeAlterada = cidadeRepository.saveAndFlush(cidade);
        return cidadeAlterada;
    }

    public void excluirCidade(Long cidadeId){
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(()-> new ResourceNotFoundException("Cidade nao foi encontrada."));

        cidadeRepository.delete(cidade);
    }


}
