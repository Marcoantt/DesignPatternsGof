package com.gof.designpatterns.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Entity
public class Pedido {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numPedido;
    @ManyToOne
    private Prato prato;

    //Getters e Setters

    public Long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Long numPedido) {
        this.numPedido = numPedido;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }
}
