package com.gof.designpatterns.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@Entity
public class Cliente {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private HashSet<Pedido> pedido;

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashSet<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(HashSet<Pedido> pedido) {
        this.pedido = pedido;
    }
}
