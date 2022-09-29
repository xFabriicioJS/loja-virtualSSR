package com.lojavirtual.backend.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table (name = "cidades")
@Data
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    @Temporal(TemporalType.TIMESTAMP)
    public Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    public Date dataAtualizacao;

    @ManyToOne
    //nome da coluna de relacionamento
    @JoinColumn(name = "idEstado")
    public Estado estado;




}
