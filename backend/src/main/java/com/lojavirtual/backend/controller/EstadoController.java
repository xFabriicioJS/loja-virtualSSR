package com.lojavirtual.backend.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.lojavirtual.backend.entities.Estado;
import com.lojavirtual.backend.services.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    

    @Autowired
    private EstadoService estadoService;
    

    @GetMapping("/")
    public List<Estado> buscarTodos(){
        return estadoService.buscarTodos();
    }
    
    @PostMapping("/")
    public Estado salvarEstado(@RequestBody Estado estado){
        return estadoService.salvarEstado(estado);
    }

    @PutMapping("/")
    public Estado alterarEstado(@RequestBody Estado estado){
        return estadoService.alterarEstado(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEstado(@PathVariable("id") Long estadoId){
        estadoService.excluirEstado(estadoId);

        return ResponseEntity.ok().build();
    }


}
