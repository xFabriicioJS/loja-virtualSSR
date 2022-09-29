package com.lojavirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.backend.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
