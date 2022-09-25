package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    
}
