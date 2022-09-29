package com.lojavirtual.backend.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.entities.Marca;
import com.lojavirtual.backend.services.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> listarTodos(){
        return marcaService.listarTodos();
    }

    @PostMapping("/")
    public Marca salvarMarca(@RequestBody Marca marca){
        return marcaService.salvarMarca(marca);
    }

    @PutMapping("/")
    public Marca alterarMarca(@RequestBody Marca marca){
        return marcaService.alterarMarca(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable("id") Long id){
        marcaService.excluirMarca(id);

        return ResponseEntity.ok().build();
    }
}
