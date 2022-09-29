package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
