package com.lojavirtual.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.entities.Marca;
import com.lojavirtual.backend.exceptions.ResourceNotFoundException;
import com.lojavirtual.backend.repositories.MarcaRepository;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodos(){
        return marcaRepository.findAll();
    }

    public Marca salvarMarca(Marca marca){
        marca.setDataCriacao(new Date());

        Marca novaMarca =  marcaRepository.saveAndFlush(marca);
        
        return novaMarca;
    }

    public Marca alterarMarca(Marca marca){
            marca.setDataAtualizacao(new Date());
            Marca marcaAlterada = marcaRepository.saveAndFlush(marca);
            return marcaAlterada;
    }

    public void excluirMarca(Long id){
        Marca marca = marcaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Marca nao encontrada! Id: " + id));

        marcaRepository.delete(marca);
    }



}
