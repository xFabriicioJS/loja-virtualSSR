package com.lojavirtual.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.entities.Estado;
import com.lojavirtual.backend.exceptions.ResourceNotFoundException;
import com.lojavirtual.backend.repositories.EstadoRepository;

@Service
public class CidadeService {
    
    @Autowired
    EstadoRepository estadoRepository;


    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado salvarEstado(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterarEstado(Estado estado){
        estado.setDataAtualizacao(new Date());
        Estado estadoAlterado = estadoRepository.saveAndFlush(estado);
        return estadoAlterado;
    }

    public void excluirEstado(Long estadoId){
        Estado estado = estadoRepository.findById(estadoId).orElseThrow(()-> new ResourceNotFoundException("Estado não encontrado!"));

        estadoRepository.delete(estado);
    }


}
