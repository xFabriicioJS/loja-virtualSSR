package com.lojavirtual.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {
    
    public String hello(){
        return "Olá mundo!";
    }

}
