package com.gof.designpatterns.service;


import com.gof.designpatterns.model.Cliente;
import com.gof.designpatterns.model.Pedido;
import com.gof.designpatterns.model.Prato;

import java.util.Optional;

public interface ClienteService {

    Iterable<Pedido> conferirPedidos();

    Pedido conferirPedidoPeloId(Long id);

    void fazerPedido(String nome, String nomePedido);

    void pagarPedido(Long num);

    Iterable<Prato> conferirPratos();
}
