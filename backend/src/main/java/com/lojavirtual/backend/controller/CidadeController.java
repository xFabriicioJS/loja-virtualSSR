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

import com.lojavirtual.backend.entities.Cidade;
import com.lojavirtual.backend.services.CidadeService;


@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
    

    @Autowired
    private CidadeService cidadeService;
    

    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }
    
    @PostMapping("/")
    public Cidade salvarCidade(@RequestBody Cidade cidade){
        return cidadeService.salvarCidade(cidade);
    }

    @PutMapping("/")
    public Cidade alterarCidade(@RequestBody Cidade cidade){
        return cidadeService.alterarCidade(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCidade(@PathVariable("id") Long cidadeId){
        cidadeService.excluirCidade(cidadeId);

        return ResponseEntity.ok().build();
    }


}
