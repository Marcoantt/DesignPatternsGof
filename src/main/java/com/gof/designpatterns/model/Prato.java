package com.gof.designpatterns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prato {
    @Id
    private String nomePrato;
    private Integer quantidade;
    private Double preco;

    //Getters e Setters

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}