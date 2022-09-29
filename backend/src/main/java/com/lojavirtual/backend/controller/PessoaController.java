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

import com.lojavirtual.backend.entities.Pessoa;
import com.lojavirtual.backend.services.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    
    @GetMapping("/")
    public List<Pessoa> listarTodos(){
        return pessoaService.buscarTodos();
    }

    @PostMapping
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.salvarPessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable("id") Long pessoaId){
        pessoaService.excluirPessoa(pessoaId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.alterarPessoa(pessoa);
    }
    
}
