package com.gof.designpatterns.service;

import com.gof.designpatterns.model.Cliente;
import com.gof.designpatterns.model.Prato;

public interface AdminService {
    Iterable<Cliente> buscarClientes();

    void removerCliente(Long id);

    void cancelarPedido(Long numPedido);

    Cliente buscarClientePorPedido(Long pedidoNum);

    void adicionarPrato(Prato prato);
}
